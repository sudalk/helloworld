package com.lk.leecode.code;

/**
 * 不同路径，类似简单迷宫问题
 */
public class Leecode49butonglujing {

    private int m;
    private int n;
    private int count;
    public int uniquePaths(int a, int b) {
        m =a;
        n=b;
        count =0;
        search(0,0);
        return count;
    }

    public void search(int i, int j){
        if(i == m-1 && j==n-1){
            count++;
            return;
        }
        //向下走
        if((i+1)<m && j<n){
            search(i+1,j);
        }
        //向右走
        if(i<m && (j+1)<n){
            search(i,j+1);
        }
    }

    //优化  动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) dp[i][0]=1;
        for(int j=0;j<n;j++) dp[0][j]=1;
        for(int i =1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
