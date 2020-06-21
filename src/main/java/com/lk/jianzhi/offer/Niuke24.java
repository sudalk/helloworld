package com.lk.jianzhi.offer;

import java.util.ArrayList;

/**
 * @Author: likang
 * @Date: 2020/5/1 15:45
 */
public class Niuke24 {

    /**
     * 输入一颗二叉树的根节点和一个整数，
     * 打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return result;
        }
        list.add(root.val);//加入节点
        if(target == root.val && root.left==null&&root.right==null){
            result.add(new ArrayList<>(list));
        }
        //进行dfs深度优先遍历
        FindPath(root.left, target-root.val);
        FindPath(root.right, target-root.val);
        list.remove(list.size()-1);//退出节点
        return result;
    }

    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {
        if(root == null)
            return result;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<Integer>(list));
        ArrayList<ArrayList<Integer>> result1 = FindPath(root.left, target);
        ArrayList<ArrayList<Integer>> result2 = FindPath(root.right, target);
        list.remove(list.size()-1);
        return result;
    }


}
