package com.lk.leecode.code;

/**
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class Leecode8 {

    /**
     *思路：
     *
     */

    public int majorityElement(int[] nums) {
        int res =0;
        int count =0;
        for(int num:nums){
            if(count == 0){
                res = num;
            }
            if(num == res){
                count++;
            }else{
                count--;
            }
        }
        return res;
    }
}
