package com.lk.leecode.code;

/**
 * 二叉树的直径
 */
public class Leecode22 {

/**
 * 关键字：二叉树 递归 分层 左右 根  高度
 * 思路：
 *      求根节点两边左右子树的高度
 *      高度和
 *      求高度
 */
int res;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxDepth(root);
        return res;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        res = Math.max(res,l+r);
        return Math.max(l,r)+1;
    }
}
