package com.lk.leecode.code;

/**
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Leecode10 {

    /**
     * 关键字：数组 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i =0, j=0;
        for(i =0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        while(j<nums.length){
            nums[j] = 0;
            j++;
        }
    }
}
