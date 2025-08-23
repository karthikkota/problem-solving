package com.algorithm.app;

public class Tree {

    // LC 700
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        if (root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }
    
    int minDif = Integer.MAX_VALUE;
    TreeNode prev = null;

    // LC 530
    public int getMinimumDifference(TreeNode root) {
        dfsWithPrevNode(root);
        return minDif;
    }

    private void dfsWithPrevNode(TreeNode root) {
        if (root == null)
            return;

        dfsWithPrevNode(root.left);
        if (prev != null) {
            minDif = Math.min(root.val - prev.val, minDif);
        }
        prev = root;
        dfsWithPrevNode(root.right);
    }
}
