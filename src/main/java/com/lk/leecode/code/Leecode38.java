package com.lk.leecode.code;

/**
 * 从前序和中序遍历序列构造二叉树
 */
public class Leecode38 {

    /**
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return createTree(preorder,inorder,0,0,n);
    }

    public TreeNode createTree(int[] preorder, int[] inorder, int preStart, int inStart, int n){
        //如果只剩一个节点，左右子树均为空
        if(n<=0){
            return null;
        }
        //创建当前节点 根节点就是第一个节点
        int res = preorder[preStart];
        TreeNode node = new TreeNode(res);
        //在中序中找到左右字数的分断点
        int i = 0;
        while(i<n && (res!=inorder[inStart+i])){
            i++;
        }
        node.left = createTree(preorder, inorder, preStart+1, inStart, i);
        node.right = createTree(preorder, inorder, preStart+i+1, inStart+i+1, n-1-i);

        return node;
    }
}
