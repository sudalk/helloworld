package com.example.demo.utils.pool.threadpool.task;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: likang
 * @Date: 2021/3/7 14:46
 */
public abstract class BaseCallable<T> implements Callable<T> {

    public static final long WAIT_TIME_OUT_IN_MILLIS = 800;

    private static long totalCount = 0;

    private final long addedTime = System.currentTimeMillis();

    private String logStr;

    protected ThreadPoolExecutor executor;

    protected volatile CountDownLatch countDownLatch;

    public BaseCallable(){}

    public BaseCallable(String logStr){ this.logStr = logStr;}

    @Override
    public T call() throws Exception {
        try {
            long now = System.currentTimeMillis();
            long waitTime = now - addedTime;
            if (waitTime > 0) {
                System.out.println(executor.getCorePoolSize() + executor.getTaskCount());
            }
            T result = doCall();
            if(executor != null && totalCount++ % 30 == 0){
                printoutInfo();
            }

            return result;
        }catch (Exception e){

        }finally {
            if(countDownLatch != null){
                countDownLatch.countDown();
            }
        }
        return null;
    }

    protected abstract T doCall();

    private long getWaitTimeOutInMillis() {
        return WAIT_TIME_OUT_IN_MILLIS;
    }

    public BaseCallable<T> setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
        return this;
    }

    public BaseCallable<T> setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        return this;
    }

    public BaseCallable<T> setLogStr(String logStr) {
        this.logStr = logStr;
        return this;
    }

    private void printoutInfo() {
        System.out.println(executor.getQueue().size() + executor.getTaskCount() +
                executor.getCompletedTaskCount()+ executor.getActiveCount());
    }
}
