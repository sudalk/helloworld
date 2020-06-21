package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 16:00
 */
public class Niuke4 {

    /*
    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int n = pre.length;
        TreeNode treeNode = reConstruct(pre, in, 0, 0, n);
        return treeNode;
    }

    public TreeNode reConstruct(int[] pre, int[] in, int preIndex, int inIndex, int n){
        //如果只剩一个节点，左右子树均为空
        if(n<=0){
            return null;
        }
        int a = pre[preIndex];
        //在中序中找到左右字数的分断点
        int i = 0;
        while(i<n && a != in[inIndex+i]){
            i++;
        }
        TreeNode root = new TreeNode(a);
        root.left = reConstruct(pre, in, preIndex+1, inIndex, i);
        root.right = reConstruct(pre, in, preIndex+i+1, inIndex+i+1, n-1-i);
        return root;
    }

    public static void main(String[] args) {

    }
}
