package com.base;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: likang
 * @Date: 2020/4/28 23:44
 */
public class ProductConsumerBlockQueue {

    class Resource {
        private volatile boolean flag = true;//默认开启生产者
        private AtomicInteger atomicInteger = new AtomicInteger();
        private BlockingQueue<String> blockingQueue = null;

        public Resource(BlockingQueue<String> queue){
            this.blockingQueue =  queue;
        }

        public void prod(){
            while(flag){

            }
        }
    }
}
