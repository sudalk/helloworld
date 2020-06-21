package com.lk.leecode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Leecode23  {
    /**
     *关键字：数组  哈希表
     * 不能重复：取出来的值下标不一样即可 ： hash.get(value)!=i
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            hash.put(nums[i], i);
        }
        for(int i = 0; i<nums.length;i++){
            int value = target-nums[i];
            if(hash.get(value)!=null && hash.get(value)!=i){
                result[0] = i;
                result[1] = hash.get(value);
                break;
            }
        }
        return result;
    }
}
