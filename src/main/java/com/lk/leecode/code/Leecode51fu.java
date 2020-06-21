package com.lk.leecode.code;

public class Leecode51fu {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        recurseTree(root, p, q);
        return ans;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        int root = (currentNode == p || currentNode == q) ? 1 : 0;
        if (root + left + right >= 2) {
            this.ans = currentNode;
        }
        return (root + left + right > 0);
    }
}
