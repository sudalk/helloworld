package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/3 14:59
 */
public class Niuke41 {

    public String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0) return str;
        char[] chars = str.toCharArray();
        reverseChars(chars, 0, str.length() - 1);
        // 利用滑动窗口
        // 遇到' '执行翻转
        int l = 0;
        int r = 0;
        while (l < str.length()) {
            if (chars[r] == ' ') {
                reverseChars(chars, l, r - 1);
                // 交换完之后,一起跳过' '
                r++;
                l = r;
            }
            if (r == str.length() - 1) {
                reverseChars(chars, l, r);
                // 到了最后交换玩就break，否则r会出现越界，可以在while中加对r的判断
                break;
            }
            r++;
        }
        return String.valueOf(chars);
    }
    private void reverseChars(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
