package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/3 18:45
 */
public class Niuke43 {


    /**
     *思路：判断条件
     * 1.出现e或则E, 后面必须有数字，不能出现两个e
     * 2.出现小数点 后面不能有小数点和，e不能出现过
     * 3.不合法的数也不行
     * 4.第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
     * 第二次出现+-符号，则必须紧接在e之后
     */
    public boolean isNumeric(char[] str) {

        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i ==  str.length-1) return false; // e后面一定要接数字
                if (hasE) return false;  // 不能同时存在两个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') // 不合法字符
                return false;
        }
        return true;
    }
}
