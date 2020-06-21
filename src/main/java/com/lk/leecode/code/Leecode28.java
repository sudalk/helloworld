package com.lk.leecode.code;

/**
 * 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 */
public class Leecode28 {

    /**
     * 关键字： 比特位  找规律
     *思路；
     *      P(x+b)=P(x)+1,b=2^m>x
     */

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num) {
            while(i < b && i + b <= num){
                res[i + b] = res[i] + 1;
                ++i;
            }
            i = 0;
            b <<= 1;
        }
        return res;
    }
}
