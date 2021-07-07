
class GraphProblem {

    // LC 230, T-O(N), S-O(H)
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

    // LC 103 T-O(N), S-O(H)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;

        List<List<Integer>> res = new ArrayList();
        Deque<TreeNode> sLeft2right = new ArrayDeque();
        Deque<TreeNode> sRight2left = new ArrayDeque();

        sLeft2right.push(root);
        List<Integer> curLevel = new ArrayList();

        while (!sLeft2right.isEmpty() || !sRight2left.isEmpty()) {
            while (!sLeft2right.isEmpty()) {
                TreeNode curN = sLeft2right.pop();
                curLevel.add(curN.val);

                if (curN.left != null) sRight2left.push(curN.left);
                if (curN.right != null) sRight2left.push(curN.right);
            }

            if (!curLevel.isEmpty()) res.add(new ArrayList<>(curLevel));
            curLevel.clear();

            while (!sRight2left.isEmpty()) {
                TreeNode curN = sRight2left.pop();
                curLevel.add(curN.val);

                if (curN.right != null) sLeft2right.push(curN.right);
                if (curN.left != null) sLeft2right.push(curN.left);
            }

            if (!curLevel.isEmpty()) res.add(new ArrayList<>(curLevel));
            curLevel.clear();
        }

        return res;
    }
}