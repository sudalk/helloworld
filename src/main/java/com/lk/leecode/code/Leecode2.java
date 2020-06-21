package com.lk.leecode.code;

public class Leecode2 {

    /**
     * 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 题解：
     *      关键字：位运算
     *      思路：整数取异或，算出1的个数
     *            每个位置都与1做晕眩
     */
    public int hammingDistance(int x, int y) {
        int xy = x^y;
        int dis = 0;
        while(xy!=0){
            dis+= xy&1;
            xy = xy>>1;
        }
        return dis;
    }
}
