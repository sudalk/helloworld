package com.lk.leecode.code;

/**
 * 题目：矩阵中的最短路径
 * 关键字：动态规划 需要公式
 *
 */
public class Leecode37lujing {

    /**
     * 思路：
     * 公式：dp[i][j]=min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j])
     * 如何解读这个公式呢
     * 遍历即可
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i =0; i< m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    dp[i][j] = grid[i][j];
                }
                else if(i==0){//往右走
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                else if(j==0){//往下走
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                else{//否则，就只能选择最小的走
                    dp[i][j] = Math.min(dp[i - 1][j]+ grid[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
        }
        //最终返回
        return dp[m-1][n-1];
    }

}
