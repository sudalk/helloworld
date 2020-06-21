package com.lk.leecode.code;

/**
 * 对称二叉树
 */
public class Leecode16 {

    /*
        关键字：二叉树  参数传递  拆分
        思路：
            把树拆分为左右
            遍历
            左右对称的条件是：左左右右 左右右左
    */
    public boolean isSymmetric(TreeNode root) {
        return isDuichen(root, root);
    }

    public boolean isDuichen(TreeNode l, TreeNode r){
        if(l==null && r == null) return true;
        if(l == null || r == null) return false;
        return (l.val == r.val) && isDuichen(l.left, r.right)
                && isDuichen(l.right, r.left);
    }
}
