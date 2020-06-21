package com.lk.leecode.code;

/**
 * 爬楼梯
 */
public class Leecode24 {

    /**
     * f(1) =1
     * f(2) = 2
     * f(n) = f(n-1) + f(n-2)
     */
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int f = 1;
        int s = 2;
        int ss;
        for(int i = 3;i<=n;i++ ){
            ss = f+s;
            f = s;
            s = ss;
        }
        return s;
    }
}
