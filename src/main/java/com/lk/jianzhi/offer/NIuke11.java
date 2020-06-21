package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 21:06
 */
public class NIuke11 {


    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NIuke11().NumberOf1(3));
    }
}
