package com.example.demo.utils.pool.threadpool;

import com.example.demo.utils.pool.threadpool.task.BaseCallable;
import com.example.demo.utils.pool.threadpool.task.BaskTask;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: likang
 * @Date: 2021/3/7 15:11
 */
public class ThreadPoolExecutorUtil {

    private static final Map<Integer, ThreadPoolExecutor> container = new HashMap<>();

    private static final Map<Integer, ThreadPoolExecutor> discard_container = new HashMap<>();

    private static final int EXECUTOR_SIZE = 10;

    private static final ScheduledThreadPoolExecutor scheduled;

    static {
        for(int i = 0; i < EXECUTOR_SIZE; i++){
            ThreadPoolExecutor executor = new ThreadPoolExecutor(
                    2,
                    4,
                    3,
                    TimeUnit.MINUTES,
                    new LinkedBlockingDeque<>(30),
                    new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
                    new ThreadPoolExecutor.CallerRunsPolicy()
            );
            container.put(i, executor);
        }
        scheduled = new ScheduledThreadPoolExecutor(3, new ThreadFactoryBuilder().setNameFormat("test").build());

    }

    static {
        for(int i = 0; i < EXECUTOR_SIZE; i++){
            ThreadPoolExecutor executor = new ThreadPoolExecutor(
                    2,
                    4,
                    3,
                    TimeUnit.MINUTES,
                    new LinkedBlockingDeque<>(30),
                    new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
                    new ThreadPoolExecutor.CallerRunsPolicy()
            );
            discard_container.put(i, executor);
        }
    }

    public static ThreadPoolExecutor getExecutor(String logStr){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int index = random.nextInt(EXECUTOR_SIZE);
        return container.get(index);
    }

    public static ThreadPoolExecutor getDisExecutor(String logStr){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int index = random.nextInt(EXECUTOR_SIZE);
        return discard_container.get(index);
    }

    public static void executeTask(String logStr, BaskTask task){
        ThreadPoolExecutor executor = getExecutor(logStr);
        executor.submit(task.setExecutor(executor).setLogStr(logStr));
    }

    public static <T> Future<T> submit(String logStr, BaseCallable<T> callable){
        ThreadPoolExecutor executor = getExecutor(logStr);
        Future<T> result = executor.submit(callable.setExecutor(executor).setLogStr(logStr));
        return result;

    }

    public <T> Future<T> submity(String logStr, BaseCallable<T> callable){
        ThreadPoolExecutor executor = getExecutor(logStr);
        Future<T> result = executor.submit(callable.setExecutor(executor).setLogStr(logStr));
        return result;
    }

}
