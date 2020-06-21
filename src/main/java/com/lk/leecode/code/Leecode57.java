package com.lk.leecode.code;

/**
 * @Author: likang
 * @Date: 2020/4/13 10:36
 */
public class Leecode57 {

    /*
    跳跃2：
     */
    public int jump(int[] nums) {
        int ans = 0;
        //第一次跳跃的最后一个位置为当前的第一个位置
        int end = 0;
        //初始化最大的步数
        int maxPos = 0;
        for(int i = 0; i < nums.length-1; i++){
            //计算从起始位置到当前步数达到的最大值
            maxPos = Math.max(maxPos, i+nums[i]);
            //判断当前位置是否已经到达了当前步的最大值
            if(i == end){
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }
}
