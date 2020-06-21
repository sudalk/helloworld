package com.lk.leecode.code;

/**
 * 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class Leecode11 {


    /**
     * 关键字： 递归 二叉树  后序遍历
     *思路：
     *      记录和的参数
     *      遍历顺序  右 中（操作是加起来的和）  左
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum+=root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
