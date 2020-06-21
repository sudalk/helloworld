package com.lk.jianzhi.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author: likang
 * @Date: 2020/5/1 19:09
 */
public class Niuke28 {

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] nums, int k) {
        if(k <= 0 || k > nums.length ){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2)->n2-n1);
        for(int i = 0; i< nums.length; i++){
            queue.offer(nums[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return new ArrayList<>(queue);
    }
}
