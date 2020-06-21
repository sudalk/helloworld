package com.lk.jianzhi.offer;

import java.util.ArrayList;

/**
 * @Author: likang
 * @Date: 2020/5/3 11:26
 */
public class Niuke38 {


    /**
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * 思路：
     * 输入sum=20（1，2，3，4，5，6，7，8，9，10，11，12，13，14，15
     * 1，定义两个指针，左指针从1开始，右指针从2开始
     * 循环开始
     * 2，求和（1+2 = 3
     * 3，如果判断3小于20，右指针++，2变为3，求和3+3=6。循环一直到右指针=6，和为21。
     * 4，else if 判断21大于20，左指针++，1变为2，和减去左指针值，和为21-1=20。
     * 5，else 和与输入一样，存数。   【再把右指针++，求和，求剩余组合】
     * 循环结束
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 0) {
            return res;
        }
        int leftP = 1;
        int rightP = 2;
        int sumVal = leftP + rightP;
        while (sum > rightP) {
            if (sumVal < sum) {
                rightP++;
                sumVal += rightP;
            } else if (sumVal > sum) {
                sumVal -= leftP;
                leftP++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = leftP; i <= rightP; i++) {
                    list.add(i);
                }
                res.add(list);
                rightP++;
                sumVal += rightP;
            }
        }
        return res;
    }

}
