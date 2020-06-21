package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 18:12
 */
public class Niuke8 {

    public int JumpFloor(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else if (target ==2) {
            return 2;
        } else {
            return  JumpFloor(target-1)+JumpFloor(target-2);
        }
    }
}
