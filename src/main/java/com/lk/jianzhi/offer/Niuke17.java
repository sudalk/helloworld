package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 22:51
 */
public class Niuke17 {

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null || root1==null)
            return false;
        return hastree(root1, root2) || HasSubtree(root1.left, root2) ||HasSubtree(root1.right, root2);
    }
    public boolean hastree(TreeNode root1,TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val == root2.val){
            return hastree(root1.left,root2.left) && hastree(root1.right,root2.right);
        }else{
            return false;
        }
    }

}
