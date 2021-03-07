package com.example.demo.utils.pool.threadpool.task;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: likang
 * @Date: 2021/3/7 14:01
 */
public abstract class BaskTask implements Runnable{

    public static final long WAIT_TIME_OUT_IN_MILLIS = 800;

    private static long totalCount = 0;

    private final long addedTime = System.currentTimeMillis();

    private String logStr;

    protected ThreadPoolExecutor executor;

    protected volatile CountDownLatch countDownLatch;

    public BaskTask(){}

    public BaskTask(String logStr){ this.logStr = logStr;}

    @Override
    public void run() {
        try{
            long now = System.currentTimeMillis();
            long waitTime = now - addedTime;
            if(waitTime > getWaitTimeOutInMillis()){
                //如果超过时间，不执行，输出error
                return;
            }
            //执行业务逻辑
            doTask();
            long end = System.currentTimeMillis();
            //统计抽样
            if(executor != null && totalCount++ % 30 == 0){
                printoutInfo();
            }

        }catch (Exception e){
        }finally {
            if(countDownLatch != null){
                countDownLatch.countDown();
            }
        }
    }

    private void printoutInfo() {
        System.out.println(executor.getQueue().size() + executor.getTaskCount() +
                executor.getCompletedTaskCount()+ executor.getActiveCount());
    }

    protected abstract void doTask();


    private long getWaitTimeOutInMillis() {
        return WAIT_TIME_OUT_IN_MILLIS;
    }

    public BaskTask setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
        return this;
    }

    public BaskTask setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        return this;
    }

    public BaskTask setLogStr(String logStr) {
        this.logStr = logStr;
        return this;
    }
}
