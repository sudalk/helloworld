package com.lk.leecode.code;

import org.springframework.util.StringUtils;

/**
 * @Author: likang
 * @Date: 2020/4/12 15:40
 */
public class Leecode55 {
    //最长公共子序列
    /*
    思路：
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        char[] chas1 = text1.toCharArray();
        char[] chas2 = text2.toCharArray();
        int m = chas1.length, n = chas2.length;
        int[][] dp = new int[m][n];
        dp[0][0] = chas1[0] == chas2[0] ? 1 : 0;
        for (int i = 1; i < m; i++) dp[i][0] = chas1[i] == chas2[0] ? 1 : dp[i - 1][0];
        for (int j = 1; j < n; j++) dp[0][j] = chas1[0] == chas2[j] ? 1 : dp[0][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (chas1[i] == chas2[j]) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[m - 1][n - 1];
    }

    public int getLongSub(String s1, String s2){
        if(StringUtils.isEmpty(s1)||StringUtils.isEmpty(s2)){
            return 0;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int m = chars1.length; int n = chars2.length;
        int[][] dp = new int[m][n];
        dp[0][0] = chars1[0]==chars2[0]?1:0;
        for (int i = 1; i < m; i++) dp[i][0] = chars1[i] == chars2[0] ? 1 : dp[i - 1][0];
        for (int j = 1; j < n; j++) dp[0][j] = chars1[0] == chars2[j] ? 1 : dp[0][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (chars1[i] == chars2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }
        return dp[m - 1][n - 1];
    }
}
