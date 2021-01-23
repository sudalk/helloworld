package com.example.demo.utils.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: likang
 * @Date: 2021/1/16 21:23
 */
public class ExecuteServiceTest {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("abcdefg");
            }
        });

        executorService.shutdown();
    }
}
