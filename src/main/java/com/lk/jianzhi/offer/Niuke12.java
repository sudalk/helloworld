package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 21:21
 */
public class Niuke12 {

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     */
    public double Power(double base, int exponent) {
        double result = 1.0;
        if(base == 0.0)
            return 0.0;
        if(exponent == 0)
            return 1.0;
        if(exponent < 0){
            for(int i = 0; i< Math.abs(exponent);i++){
                result *= base;
            }
            return 1/result;
        }else{
            for(int i = 0; i< Math.abs(exponent);i++){
                result *= base;
            }
            return result;
        }
    }

}
