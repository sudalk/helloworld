package com.lk.leecode.code;

import java.util.PriorityQueue;

/**
 * 第k大的数
 */
public class Leecode43 {
    /**
     * 思路：
     *      建立一个小顶堆，放进k个数据，堆顶为k大的数
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1, n2)->n1-n2);
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
