package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 18:26
 */
public class Niuke10 {

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     */
    public int RectCover(int target) {
        if (target <1 ){
            return 0;
        }
        if (target ==1||target ==2){
            return target;
        }
        else {
            return RectCover(target-1)+RectCover(target-2);
        }

    }
}
