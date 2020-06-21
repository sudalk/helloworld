package com.lk.leecode.code;

public class Leecode52 {

    /**
     *无重复字符的最长子串 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 滑动窗口aaa[abc]b
     * 每一次都和后面的比较,后面的标志位left开始到当前位置
     * 最后每次比较保存
     */
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int left = 0, max = 0;

        for(int i=0;i<array.length;i++){
            char a = array[i];
            for(int j = left;j<i; j++){
                if(a == array[j]){
                    left = j+1;
                    break;
                }
            }
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}
