package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 17:56
 */
public class Niuke7 {

    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        int f=0,g=1;
        for(int i = 2; i<=n; i++){
            int temp = g;
            g = g+f;
            f = temp;
        }
        return g;
    }

    public static void main(String[] args) {
        System.out.println(new Niuke7().Fibonacci(2));
    }

}
