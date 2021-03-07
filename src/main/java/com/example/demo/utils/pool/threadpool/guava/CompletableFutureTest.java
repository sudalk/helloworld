package com.example.demo.utils.pool.threadpool.guava;

import com.example.demo.utils.pool.threadpool.ThreadPoolExecutorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Author: likang
 * @Date: 2021/3/7 16:33
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        List<CompletableFuture<String>> asynList = new ArrayList<>();
        for(int i = 0; i< 10; i++ ){
            int finalI = i;
            asynList.add(CompletableFuture.supplyAsync(()->{
                if(finalI%2==0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return ""+ finalI;
            }, ThreadPoolExecutorUtil.getExecutor("")));
        }
        CompletableFuture.allOf(asynList.toArray(new CompletableFuture[0]));
        List<String> collect = asynList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        collect.forEach(item->{
            System.out.println(item);
        });

    }
}
