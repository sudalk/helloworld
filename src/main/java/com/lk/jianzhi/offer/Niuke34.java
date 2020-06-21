package com.lk.jianzhi.offer;

import java.util.HashMap;

/**
 * @Author: likang
 * @Date: 2020/5/2 12:51
 */
public class Niuke34 {

    /**
     * 出现一次的数，有两个
     */
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        //哈希算法
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i < array.length; i++){
            if(map.containsKey(array[i]))
                map.put(array[i],2);
            else
                map.put(array[i],1);
        }
        int count = 0;
        for(int i=0; i < array.length; i++){
            if(map.get(array[i]) == 1){
                if(count == 0){
                    num1[0] =  array[i];
                    count++;
                }else
                    num2[0] =  array[i];
            }
        }

    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int a = 0;
        //求出异或
        for(int arr : array){
            a = a ^ arr;
        }
        //求出数值
        int index = 1;
        while((index&a)==0){
            index = index<<1;
        }
        //分成两个数组进行异或，方法就是index&arr
        int res1 = 0 , res2 = 0;
        for(int i=0;i<array.length;i++){
            if((index & array[i])==0){
                res1 = res1 ^ array[i];
            }else{
                res2 = res2 ^ array[i];
            }
        }
        num1[0] = res1;
        num2[0] = res2;
    }

}
