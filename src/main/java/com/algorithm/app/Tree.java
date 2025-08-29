package com.algorithm.app;

public class Tree {

    // LC 112
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    
    // LC 108
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return treeBuilder(0, nums.length - 1);
    }

    private TreeNode treeBuilder(int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = treeBuilder(0, mid - 1);
        root.right = treeBuilder(mid + 1, right);
        return root;

    }
    
    // LC 104
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    // LC 100
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if ((p == null && q != null) || (p != null && q == null))
            return false;

        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    // LC 94
    List<Integer> list = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
    
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
