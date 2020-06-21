package com.lk.jianzhi.offer;

import java.util.ArrayList;

/**
 * @Author: likang
 * @Date: 2020/5/3 13:28
 */
public class Niuke39 {

    /**
     * 输入一个递增排序的数组和一个数字S,和为s的连续序列
     * 思路： 双指针，最前和最后
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array.length < 2){
            return res;
        }
        int i = 0, j = array.length-1;
        while(i<j){
            int temp = array[i]+array[j];
            if(temp>sum){
                j--;
            }else if(temp<sum){
                i++;
            }else{
                res.add(array[i]);
                res.add(array[j]);
                break;
            }
        }
        return res;
    }
}
