package com.lk.leecode.code;

/**
 * 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Leecode35 {
    /**
     * 关键字： 动态规划 非递归回溯
     * 思路：
     *      结果G(n) 可以分解为以每个节点为根节点的所有二叉树的总和，F(i,n) i从1到n
     *      F(i,n)就是 G(i-1)*G(n-i)
     *      初始值 G(0) = 1 G(1) = 1
     */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;
        for(int j=2;j<=n;j++){
            //这边就是求解G(j)
            for(int i=1;i<=j;j++){
                G[j]+= G[i-1]*G[j-i];
            }
        }
        return G[n];
    }


}
