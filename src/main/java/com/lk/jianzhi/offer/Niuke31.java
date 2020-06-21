package com.lk.jianzhi.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: likang
 * @Date: 2020/5/2 11:11
 */
public class Niuke31 {

    /**
     * 把数组排成最小的数
     * 如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
     */
    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int num:numbers){
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1+""+o2;
                String str2 = o2+""+o1;
                return str1.compareTo(str2);
            }
        });
        String res = "";
        for(Integer i : list){
            res =res+i;
        }
        return res;
    }
}
