package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/2 11:26
 */
public class Niuke32 {

    /**
     *思路：全部由字母组成
     *hashmap的思想，利用字母对应的ASCII码的值作为下标和key
     */
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length() == 0)
            return -1;
        int[] hash = new int[256];
        for(int i=0; i < str.length();i++)
            hash[str.charAt(i)]++;
        for(int i=0; i < str.length();i++){
            if(hash[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}
