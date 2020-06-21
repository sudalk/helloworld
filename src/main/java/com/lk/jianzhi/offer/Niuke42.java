package com.lk.jianzhi.offer;

import java.util.TreeSet;

/**
 * @Author: likang
 * @Date: 2020/5/3 17:30
 */
public class Niuke42 {

    /**
     * 思路：五个数计数0和去重复，最后的条件是第一个和最后一个数的差值不能大于等于5
     */
    public boolean isContinuous(int [] n) {
        if (n.length < 5 || n.length > 5) {
            return false;
        }
        int num = 0;
        TreeSet<Integer> set = new TreeSet<> ();
        for (int i=0; i<n.length;i++) {
            if (n[i]==0) {
                num ++;
            } else {
                set.add(n[i]);
            }
        }
        if ((num + set.size()) != 5) {
            return false;
        }
        if ((set.last() - set.first()) < 5) {
            return true;
        }
        return false;
    }
}
