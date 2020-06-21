package com.lk.leecode.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代的中序遍历
 */
public class Leecode31 {
    /**
     * 思路：
     *      递归转为栈
     *      找到最左边的（根） =  如果有右子树（进栈） == 没有则到下一个根节点
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            //找到最左边
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            //根节点出来
            curr = stack.pop();
            res.add(curr.val);
            //查看右子树,如果右子树不为空，则进，如果右子树为空，接着出栈。
            curr = curr.right;
        }
        return res;
    }
}
