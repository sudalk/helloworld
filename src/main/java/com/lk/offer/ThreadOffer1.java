package com.lk.offer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: likang
 * @Date: 2020/4/10 13:57
 */
public class ThreadOffer1 {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Condition aa = lock.newCondition();
        Condition bb = lock.newCondition();
        int []a = {1,2,3};
        char []b = {'a','b','c'};
        new Thread(()->{
            for(int i=0;i<3;i++){
                try {
                    lock.lock();
                    System.out.print(a[i]);
                    //唤醒
                    bb.signal();
                    if(i<2){
                        aa.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                }
        }).start();

        new Thread(()->{
            for(int i=0;i<3;i++){
                try {
                    lock.lock();
                    System.out.print(b[i]);
                    //唤醒
                    aa.signal();
                    if(i<2){
                        bb.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
