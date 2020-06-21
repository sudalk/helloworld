package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/3 19:52
 */
public class Niuke44 {

    /**
     * 构建乘积数组
     * 思路：
     * 正着
     * 1 2 3 4 5 6 7 8 9
     *temp = 1
     *b[0] = temp; b[1] = b[0] * a[0]
     *temp *= a[0];
     *反着
     * temp = 1
     * 1 2 3 4 5 6 7 8 9
     *b[8] *= temp
     *temp = temp*a[i]
     */
    public int[] multiply(int[] nums) {
        int left = 1;
        int right = 1;
        int n = nums.length;
        int out[] = new int[n];
        out[0] = 1;
        for(int i =1; i<n; i++){
            out[i] = out[i-1]*nums[i-1];
        }
        for(int j = n-1;j>=0;j--){
            out[j] *= right;
            right *= nums[j];
        }
        return out;
    }
}
