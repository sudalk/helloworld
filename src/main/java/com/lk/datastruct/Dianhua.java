package com.lk.datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dianhua {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> out  = new ArrayList<>();
    //由于不知道遍历的层数，只能通过带有参数的递归进行遍历

    public void digui(String res, String digitsSub){
        //首先获取当前层次的字母,如果当前没有值了，就相当于到了最后的叶子节点，直接添加结果即可
        if(digitsSub.length() == 0){
            out.add(res);
        }else{
            //获取当前的数字
            String digit = digitsSub.substring(0,1);
            String letters = phone.get(digit);
            for(int i =0; i<letters.length();i++){
                //获取当前字符
                String letter = String.valueOf(letters.charAt(i));
                res = res + letter;
                //进入下一层,去掉当前的字符
                digui(res, digitsSub.substring(1));
            }
        }


    }
    public List<String> letterCombinations(String digits) {
        if(digits == ""){
            return out;
        }
        digui("", digits);
        return out;
    }
}
