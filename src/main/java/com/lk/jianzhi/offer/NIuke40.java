package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/3 13:36
 */
public class NIuke40 {


    /**
     *
     */
    public String LeftRotateString(String str,int n) {

        if (str == null || str.length()<=1) {
            return str;
        }
        n = Math.floorMod(n, str.length());
        return str.substring(n) + str.substring(0, n);
    }

    public static void main(String[] args) {
        String abcXYZ123 = new NIuke40().LeftRotateString("abcdefg", 9);
        System.out.println(abcXYZ123);
    }
}
