package com.lk;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: likang
 * @Date: 2020/5/6 14:38
 */
public class Test {

    /**
     * 思路：
     *      lockA lockB
     *      A  lockA  sleep  lockB
     *      B  lockB  sleep  lockA
     */
    private static Lock lockA = new ReentrantLock();
    private static Lock lockB = new ReentrantLock();

    public static void main(String[] args) {

        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        hashMap.put(1,2);
        new Thread(()->{
            lockA.lock();
            System.out.println("A:已获取lockA");
            try{
                Thread.sleep(3000);
                System.out.println("A:获取lockB");
                lockB.lock();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lockB.unlock();
                lockA.unlock();
            }
        }).start();

        new Thread(()->{
            lockB.lock();
            System.out.println("B:已获取lockB");
            try{
                Thread.sleep(3000);
                System.out.println("B:获取lockA");
                lockA.lock();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lockA.unlock();
                lockB.unlock();
            }
        }).start();

    }

}
