package com.lk.leecode.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 根据身高重建队列
 * 关键字 类似桶排序吧
 */
public class Leecode41 {
    /**
     * 思路：
     *      先按照身高排序，然后按照序列排
     *      因为个子高的人看不见个子矮的，所以先排个子高的
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        List<int[]> list = new LinkedList<>();
        for(int[] p:people){
            list.add(p[1],p);
        }
        int n = people.length;
        return list.toArray(new int[n][2]);
    }
}
