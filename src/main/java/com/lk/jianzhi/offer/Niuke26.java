package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/1 18:10
 */
public class Niuke26 {


    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    TreeNode pre=null;
    public TreeNode Convert(TreeNode root) {
        if(root == null) {
            return null;
        }
        Convert(root.right);
        if(pre == null){
            pre = root;
        }else{
            root.right = pre;
            pre.left = root;
            pre = root;
        }
        Convert(root.left);
        return pre;
    }
}
