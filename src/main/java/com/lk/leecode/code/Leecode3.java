package com.lk.leecode.code;

public class Leecode3 {
    /**
     * 翻转一棵二叉树
     * 关键字：递归
     * 思路:
     *      终止条件：当前节点为空
     *      循环体：翻转左  翻转右
     *      左右子树交换
     *      返回根节点
     */

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        return root;
    }
}
