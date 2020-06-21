package com.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: likang
 * @Date: 2020/4/28 23:21
 */

class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment(){
        //加锁
        lock.lock();
        try{
            //判断
            while(number != 0){
                condition.await();
            }
            number++;
            System.out.println("生产者："+Thread.currentThread().getName()+"："+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //解锁
            lock.unlock();
        }
    }
    public void decrement(){
        //加锁
        lock.lock();
        try{
            //判断
            while(number == 0){
                condition.await();
            }
            number--;
            System.out.println("消费者："+Thread.currentThread().getName()+"："+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //解锁
            lock.unlock();
        }
    }
}

public class ProductConsumerSimple {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for(int i =1;i <=5;i++){
                try {
                    shareData.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for(int i =1;i <=5;i++){
                try {
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}
