package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/1 18:53
 */
public class Niuke27 {

    public int MoreThanHalfNum_Solution(int [] array) {
        int res = 0;
        int count = 0;
        for(int i = 0;i<array.length; i++){
            if(count == 0){
                res = array[i];
            }
            if(res == array[i]){
                count++;
            }else{
                count--;
            }
        }
        int n = 0;
        for(int num:array){
            if(num == res){
                n++;
            }
        }
        if(2 * n > array.length){
            return res;
        }else{
            return 0;
        }
    }
}
