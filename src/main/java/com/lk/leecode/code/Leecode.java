package com.lk.leecode.code;

/**
 * 路径总和 III
 */
public class Leecode {


    /**
     *关键字： 遍历  递归  带参数
     * 思路：
     *      1.根左右
     *      2.带参数 根（这边加判断即可）左右
     *
     */
    private int res =0;

    public int pathSum(TreeNode root, int sum) {
        if(root != null){
            hasPathSum(root, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);

        }
        return res;
    }

    public void hasPathSum(TreeNode root, int sum) {
        if(root != null){
            if (root.val == sum) {
                res += 1;
            }
            hasPathSum(root.left, sum-root.val);
            hasPathSum(root.right,sum-root.val);
        }
    }
}
