package com.lk.leecode.code;

import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

import java.util.Arrays;

/**
 * w温度走势和升温趋势
 */
    public class Leecode50wendu {
    /**
     *思路：
     *      next数组存储温度和所出现的位置
     *      73 62 66 75     next[75] = 3  next[66] = 2  ans[2] = (next[67---100]的最小值-next[66])=3-2=1
     */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for(int i=n-1;i>=0;i--){
            //找到之前的最小值
            int index = Integer.MAX_VALUE;
            for(int j = T[i]+1;j<=100;j++){
                if(next[j]<index){
                    index = next[j];
                }
            }
            //相减得出结果
            if(index<Integer.MAX_VALUE){
                ans[i] = index-i;
            }
            next[T[i]] = i;
        }
        return ans;
    }
}
