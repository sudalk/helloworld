package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/1 20:06
 */
public class Niuke29 {

    /**
     * 最大连续子序列的和
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int count = array[0];
        int sum = Integer.MIN_VALUE;
        for(int i = 1; i<array.length; i++){
            if(count>0){
                sum = Math.max(count+array[i],sum);
            }else{
                count = array[i];
            }
        }
        return sum;
    }
}
