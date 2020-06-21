package com.lk.leecode.code;

/**
 * 二叉树展开为链表
 */
public class Leecode30 {

    /**
     * 关键字：二叉树 链表  遍历
     * 思路： 使用前序遍历的逆序==== 右左根
     */
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
