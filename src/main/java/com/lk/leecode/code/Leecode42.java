package com.lk.leecode.code;

/**
 *盛最多水的容器
 */
public class Leecode42 {

    /**
        关键：数组
     */
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;int j= height.length-1;
        while(i<j){
            area = Math.max(area, (j-i)*Math.min(height[i],height[j]));
            if(height[i] < height[j]){
                ++i;
            }else{
                --j;
            }
        }
        return area;
    }
}
