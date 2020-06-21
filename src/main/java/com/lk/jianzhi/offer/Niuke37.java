package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/2 19:27
 */
public class Niuke37 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean stop = (sum!=0) && ((sum += Sum_Solution(n-1))!=0);
        return sum;
    }

}
