package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 15:25
 */
public class Niuke2 {

    /*
    请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        if(str == null){
            return null;
        }
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                res.append("%20");
            }else{
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Niuke2().replaceSpace(new StringBuffer("we are the world")));
    }
}
