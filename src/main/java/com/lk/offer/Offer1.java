package com.lk.offer;

import java.util.Arrays;

/**
 * @Author: likang
 * @Date: 2020/4/9 11:57
 */
public class Offer1 {

    private int findSumEqualsX( int x, int[] nums){
        Arrays.sort( nums);
        if( nums[0] >= x) return 0;
        int count=0;
        int i=0, j=nums.length-1;
        while( i<j){
            if( nums[i] + nums[ j]==x){
                count++;
                if( nums[i+1] + nums[j] ==x && i+1<j){
                    i++;
                    count++;
                }
                else  if( nums[i] + nums[j-1] ==x && j-1>i){
                    j--;
                    count++;
                }
                else
                    i++;
            }
            else if( nums[i]+nums[j] < x)  i++;
            else  j--;
        }
        return count;
    }
}
