
class GraphProblem {

    // LC 230, T-O(n), S-O(h)
    private int count = 0;
    private int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root != null) {
            inorder(root.left, k);
            count++;

            if (count == k) {
                res = root.val;
            }
            inorder(root.right, k);
        }
    }
}