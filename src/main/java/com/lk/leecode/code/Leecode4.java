package com.lk.leecode.code;

public class Leecode4   {
    /**
     *求二叉树的高度
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
