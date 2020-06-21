package com.lk.leecode.code;

import java.util.Arrays;

/**
 * 寻找重复数字
 */
public class Leecode40 {
    /**
     *先排序，后查找（遍历 二分查找）
     */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}
