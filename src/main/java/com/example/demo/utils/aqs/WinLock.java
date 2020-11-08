package com.example.demo.utils.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: likang
 * @Date: 2020/11/8 20:40
 */
public class WinLock implements Lock {
    AQS aqs = new AQS();
    @Override
    public void lock() {
        aqs.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        aqs.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

/*
总结：
数据结构：头 尾  状态  当前线程
节点：前 后 线程数据 线程状态

获取锁：
节点：
尝试获取锁，
    锁的状态为0
        判断是不是需要排队，不需要尝试获取锁
    判断是不是重入锁

失败创建节点
    尾部cas插入，设计节点的初始化

并尝试获取锁
    如果前面的节点是头结点，尝试获取锁，并直接插入
   上一个元素不是头元素，也不是等待状态，也没有获取锁，当前线程就等待
   向前清空吴用的线程，继续执行
   如果还需要等待，直接park

释放锁：
尝试释放锁
    -1操作
    设置当前线程为空
唤醒线程
    修改锁的状态，
    找到需要唤醒的节点：从尾部找到第一个可唤醒的节点
    唤醒并修改节点的线程状态




 */