package com.lk;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: likang
 * @Date: 2020/5/6 14:49
 */
public class CountDownTest {


    /**
     *
     */
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"执行开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
            countDownLatch.countDown();
        },"A").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"执行开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
            countDownLatch.countDown();
        },"B").start();

        System.out.println("主线程等待");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }
}
