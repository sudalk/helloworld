package com.lk.leecode.code;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Leecode25 {
    /**
     * 关键字：数组  增加  连续
     * 思路；最大值一定是增加的过程中出现的，
     *        如果前面出现负数就放弃，对后面的没有什么用
     *        也就是多，如果是正数，就可以继续往下加 ，否则就停止，毕竟对后面的意义不大
     */
    public int maxSubArray(int[] nums) {
        int c = nums[0];
        int s = nums[0];
        for(int i =1; i<nums.length;i++){

            if((c+nums[i])>nums[i]){
                c=c+nums[i];//如果加上之前的比本身大，就用之前的为当前步数的最大值
            }else{
                c = nums[i];//否则，就用自己，从自己开始
            }
            if(c>s){
                s=c;
            }
        }
        return s;
    }
}
