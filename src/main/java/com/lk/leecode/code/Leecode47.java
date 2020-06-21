package com.lk.leecode.code;

/**
 *
 */
public class Leecode47 {

    /**
     * 思路；
     * 回文子串  i   j=i+long-1  long代表长度  dp[i+1][j-1] 需要 s[i] == s[j]
     *
     *过程：
     *      1.先初始化长度为1和长度为2的矩阵
     *      2.从长度为3的开始，到最后，并记录最长的和起始位置
     */
    public int countSubstrings(String s) {
        String res = "";
        int length = s.length();
        char[] s1 = s.toCharArray();
        int count = 0;
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int[][] dp = new int[length][length];
        for(int i=0;i<length;i++){
            dp[i][i] = 1;
            count++;
            if(i<length-1){
                if(s1[i]==s1[i+1]){
                    dp[i][i + 1] = 1;
                    count++;
                }
            }
        }
        //3个开始
        for (int l=3;l<=length;l++){
            for(int i=0;i+l-1<length;i++){
                int j = i+l-1;
                if(s1[i]==s1[j] && dp[i+1][j-1]==1){
                    dp[i][j] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new Leecode47().countSubstrings("aaa");
    }
}
