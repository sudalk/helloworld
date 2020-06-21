package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 23:31
 */
public class Niuke18 {

    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     */
    public void Mirror(TreeNode root) {
        if(root!=null){
            TreeNode temp=null;
            temp=root.left;
            root.left=root.right;
            root.right=temp;
            
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
