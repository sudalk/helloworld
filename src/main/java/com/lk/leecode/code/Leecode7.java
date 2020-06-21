package com.lk.leecode.code;

/**
 * 题目：只出现一次
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class Leecode7 {

    /**
     * 关键字：数组 次数 === hash表
     *思路：  2a+2b+c   2(a+b+c[这个是计算的])
     * 思路2：一直异或
     *
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int j = 1;j<nums.length;j++){
            res = res^nums[j];
;        }
        return res;
    }
}
