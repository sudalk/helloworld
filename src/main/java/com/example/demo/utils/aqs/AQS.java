package com.example.demo.utils.aqs;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;


/**
 * @Author: likang
 * @Date: 2020/11/8 16:20
 */
public class AQS {

    private volatile Node head;
    private volatile Node tail;
    private volatile int status;

    private static Unsafe unsafe;
    private static long statusOffset = 0;
    private static long headOffset = 0;
    private static long tailOffset = 0;
    private static long threadStatusOffset = 0;

    static {
        try{
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            statusOffset = unsafe.objectFieldOffset(AQS.class.getDeclaredField("status"));
            headOffset = unsafe.objectFieldOffset(AQS.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset(AQS.class.getDeclaredField("tail"));
            threadStatusOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("threadStatus"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

    public void setExclusiveOwnerThread(Thread exclusiveOwnerThread) {
        this.exclusiveOwnerThread = exclusiveOwnerThread;
    }

    private transient Thread exclusiveOwnerThread;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //获取锁
    public final void acquire(int arg){
        //尝试获取锁，不成功返回false, 并且创建Node，然后尝试获取锁
        if (!tryAcquire(arg) &&
                acquireQueued(addWaiter(), arg)){
            Thread.currentThread().interrupted();
        }
    }

    //释放锁  单线程
    public final void release(int arg) {
        if (tryRelease(arg)) {
            unparkSuccessor(head);
        }
    }

    private void unparkSuccessor(Node head) {
        //修改当前锁的状态
        compareAndSetState(getStatus(), 0);
        Node next = null;
        Node h = head;
        if(h != null ){
            next = h.next;
        }
        if(next == null || next.threadStatus != Node.WAIT){
            for(Node t = tail;t!=null&&t!= h;t=t.prev){
                if(t.threadStatus!= Node.CANCEL){
                    next = t;
                }
            }
        }
        if(next != null){
            System.out.println(Thread.currentThread().getName()+"唤醒线程"+next.thread.getName());
            unsafe.unpark(next.thread);
            compareAndSetNodeStatus(next, next.threadStatus, Node.DEFAULT);
        }
    }

    private boolean tryRelease(int arg) {
        int c = getStatus() - arg;
        if(Thread.currentThread() != getExclusiveOwnerThread()){
            throw new RuntimeException("释放所的线程不是当前线程");
        }
        if(c == 0){
            setExclusiveOwnerThread(null);
            System.out.println(Thread.currentThread().getName() + ":释放锁");
            return true;
        }
        setStatus(c);
        return false;
    }


    /**
     判断加入的元素要不要排队，如果不要直接获取锁成功，返回true，如果需要则阻塞
     */
    private boolean acquireQueued(Node node, int arg) {
        for(;;){
          //如果正好是头元素的下一个元素，尝试获取锁
            if(head == node.prev && tryAcquire(arg)){
                //当前线程已经获取到锁，直接设置头元素
                setHead(node);
                compareAndSetNodeStatus(node, node.threadStatus, Node.DEFAULT);
                System.out.println(Thread.currentThread().getName() + ":获取锁");
                return false;
            }
            //判断是否需要等待，需要等待直接阻塞
            if (shouldParkAfterFailedAcquire(node) &&
                    parkAndCheckInterrupt(node)){
                //return true;
            }
        }
    }

    private boolean parkAndCheckInterrupt(Node node) {
        //修改当前状态为wait
        compareAndSetNodeStatus(node, node.threadStatus, Node.WAIT);
        unsafe.park(false, 0);
        return Thread.interrupted();
    }

    private boolean shouldParkAfterFailedAcquire(Node node) {
        //上一个元素是头元素，直接循环获取
        //上一个元素本身就是等待状态，则当前也需要等待
        //上一个元素不是头元素，也不是等待状态，也没有获取锁，当前线程就等待
        Node prev = node.prev;
        if(prev != null && prev != head && prev.threadStatus != Node.CANCEL){
            //如果上一个元素存在，不是头结点，并且不是放弃状态，则需要等待
            return true;
        }
        //排除取消状态的节点，减少循环次数，保证节点尽可能的靠近头结点
        if(prev != null && prev.threadStatus == Node.CANCEL){
            do {
                node.prev = prev = prev.prev;
            }while(prev.threadStatus == Node.CANCEL);
            prev.next = node;
        }
        return false;
    }

    private boolean compareAndSetNodeStatus(Node node, int threadStatus, int aDefault) {
        return unsafe.compareAndSwapLong(node, threadStatusOffset, threadStatus, aDefault);
    }

    private void setHead(Node node) {
        head = node;
        head.prev = null;
        head.thread = null;//头部元素 已经获取的线程不需要存储 节约空间
    }

    /**
     * 添加新的元素，尾部追加，CAS操作
     * @return
     */
    private Node addWaiter() {
        Node node = new Node(Thread.currentThread());
        Node prev = tail;
        if(prev != null){
            node.prev = prev;
            //原子操作加入对尾
            if(compareAndSetTail(prev, node)){//相当于setTail
                prev.next = tail;
                return node;
            }
        }
        enq(node);
        return node;
    }

    private Node enq(Node node) {
        for (;;) {
            Node t = tail;
            if (t == null) { //队列没有初始化或者队列正在初始化
                if (compareAndSetHead(new Node()))//相当于setHead
                    tail = head;
            } else {
                node.prev = t;
                if (compareAndSetTail(t, node)) {//相当于setTail
                    t.next = node;
                    return t;
                }
            }
        }
    }

    private boolean compareAndSetHead(Node node) {
        return unsafe.compareAndSwapObject(this, headOffset, null, node);
    }

    private boolean compareAndSetTail(Node prev, Node node) {
        return unsafe.compareAndSwapObject(this, tailOffset, prev, node);
    }

    //返回获取成功的结果
    private boolean tryAcquire(int acquires) {
        //获取当前线程，获取锁的状态
        Thread current = Thread.currentThread();
        int c = getStatus();
        if(c == 0){
            //需要排队直接返回 不需要排队尝试获取锁
            if (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires)) {
                setExclusiveOwnerThread(current);
                return true;
            }

        }else if(current == getExclusiveOwnerThread()){
            //如果是当前线程，这里面都是单线程的操作,+1即可
            int nextc = c + acquires;
            if (nextc < 0)
                throw new Error("Maximum lock count exceeded");
            setStatus(nextc);
            return true;

        }
        return false;
    }

    private boolean compareAndSetState(int i, int acquires) {
        return unsafe.compareAndSwapInt(this, statusOffset, i, acquires);
    }

    /**
     * 判断自己是否需要排队
     * 如果队列不为空，并且（队列正在初始化，或者并且下一个不是当前线程）
     * 返回true
     * 如果可以获取锁，则返回false
     * @return
     */
    private boolean hasQueuedPredecessors() {
        Node h = head;
        Node t = tail;
        Node s ;
        return h != t && ( ((s=h.next)==null) || (s.thread != Thread.currentThread()));
    }


    private static class Node{
        Node prev;
        Node next;
        Thread thread;

        int threadStatus;

        static final int DEFAULT = 1;
        static final int WAIT = 0;
        static final int CANCEL = -1;

        public Node() {
        }

        public Node(Thread thread) {
            this.thread = thread;
        }

        public int getThreadStatus() {
            return threadStatus;
        }

        public void setThreadStatus(int threadStatus) {
            this.threadStatus = threadStatus;
        }


    }
}
