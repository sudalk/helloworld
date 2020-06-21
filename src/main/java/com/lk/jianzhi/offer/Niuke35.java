package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/2 16:01
 */
public class Niuke35 {

    /**
     * 判断平衡二叉树
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        int hight = TreeHight(root);
        return hight != -1;
    }

    public int TreeHight(TreeNode root){
        if(root == null){
            return 0;
        }
        //左
        int left = TreeHight(root.left);
        if(left == -1){
            return -1;
        }
        //右
        int right = TreeHight(root.right);
        if(right == -1){
            return -1;
        }
        //根
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left, right)+1;
    }

}
