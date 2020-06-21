package com.lk.leecode.code;

/*
除自身以外数组的乘积
给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

    示例:

    输入: [1,2,3,4]
    输出: [24,12,8,6]
 */
public class Leecode34 {

    /*
       关键字：数组  双指针
       思路：
            节点的结果 =  节点的左边乘积*节点的右边乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int n = nums.length;
        int out[] = new int[n];
        for(int i =0; i<n; i++){
            out[i] = left;
            left *= nums[i];
        }
        for(int j = n-1;j>=0;j--){
            out[j] *= right;
            right *= nums[j];
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] array = new Leecode34().productExceptSelf(nums);
        for(int a:array){
            System.out.print(a);
        }

    }
}
