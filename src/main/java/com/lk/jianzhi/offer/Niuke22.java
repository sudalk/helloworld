package com.lk.jianzhi.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: likang
 * @Date: 2020/5/1 13:03
 */
public class Niuke22 {

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 二叉树的层序遍历
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if(temp.left != null)queue.offer(temp.left);
            if(temp.right != null)queue.offer(temp.right);
        }
        return result;
    }

}
