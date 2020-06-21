package com.lk.leecode.code;

import java.util.*;

/**
 *  前 K 个高频元素
 */
public class Leecode44 {
    /**
     * 先统计数量
     * 再利用小顶堆
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //已key出现的频率生成一个小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2)->map.get(n1)-map.get(n2));
        for(int key : map.keySet()){
            heap.add(key);
            if(heap.size()>k){
                heap.poll();
            }
        }
        while(!heap.isEmpty()){
            res.add(heap.poll());//这个是正序拍的前十
        }
        Collections.reverse(res);//这个就是倒序排列
        return res;
    }
}
