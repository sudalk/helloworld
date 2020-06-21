package com.base;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: likang
 * @Date: 2020/4/28 23:53
 */
class ShareDataa {
    private int number = 1;//1--->A  2---->B
    private Lock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();

    private int[] arr = new int[]{1,2,3};
    private char[] brr = new char[]{'a','b','c'};

    private CountDownLatch countDownLatch = null;
    public ShareDataa(CountDownLatch countDownLatch ){
        this.countDownLatch = countDownLatch;
    }

    public void printA(){
        System.out.println(Thread.currentThread().getName()+"start");
        for(int i =0;i<3;i++) {
            lock.lock();
            try {
                while (number != 1) {
                    a.await();
                }
                System.out.println(Thread.currentThread().getName() + ":  " + arr[i] + "");
                //通知
                number = 2;
                b.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        countDownLatch.countDown();
    }
    public void printB(){
        System.out.println(Thread.currentThread().getName()+"start");
        for(int i =0;i<3;i++) {
            lock.lock();
            try {
                while (number != 2) {
                    b.await();
                }
                System.out.println(Thread.currentThread().getName() + ":  " + brr[i] + "");
                //通知
                number = 1;
                a.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        countDownLatch.countDown();
    }
}
public class LockConditions {

    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(2);
        System.out.println("begin");
        ShareDataa shareData = new ShareDataa(count);
        new Thread(()->{
            shareData.printA();
        },"A").start();
        new Thread(()->{
            shareData.printB();
        },"B").start();

        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
