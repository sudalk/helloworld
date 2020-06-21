package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/3 20:44
 */
public class Niuke46 {

    /**
     *对称二叉树
     */
    boolean isSymmetrical(TreeNode pRoot) {
        return isSub(pRoot, pRoot);
    }
    boolean isSub(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return (node1.val==node2.val)&&isSub(node1.left, node2.right)&&isSub(node1.right, node2.left);
    }
}
