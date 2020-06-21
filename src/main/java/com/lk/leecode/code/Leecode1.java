package com.lk.leecode.code;

public class Leecode1 {
/**
 * 问题：合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 思路：
 *     关键字：递归，深度遍历，根 左 右
 *     做法：先判断根节点是否为叶子节点，是否结束
 *     如果不结束，两者相加
 *     继续左左 右右
 *
 */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null)
            return null;
        if(t1==null&&t2!=null)
            return t2;
        if(t1!=null&&t2==null)
            return t1;
        t1.val = t1.val+t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
