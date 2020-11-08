package com.example.demo.utils.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: likang
 * @Date: 2020/11/8 20:41
 */
public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        Storage str = new Storage();
        for(int i = 1;i <=1000;i++){
            new Thread(()->{
                for(int j = 1;j<=10;j++){
                    str.incr();
                }
                countDownLatch.countDown();
            }, "Thread "+i).start();
        }
        countDownLatch.await();
        System.out.println("最后资源数"+ str.resource);

    }


    static class Storage{
        WinLock lock = new WinLock();
        int resource = 0;
        public void incr(){
            lock.lock();
            resource++;
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            lock.unlock();
        }
    }

}
