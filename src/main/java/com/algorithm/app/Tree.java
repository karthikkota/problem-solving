package com.algorithm.app;

public class Tree {
    // LC 94 Inorder Traversal
    List<Integer> inorder = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            inorder.add(root.val);
            inorderTraversal(root.right);
        }
        return inorder;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            inorder.add(root.val);
            root = root.right;
        }
        return inorder;
    }

    // LC 144 Preorder Traversal
    List<Integer> preorder = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            preorder.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return preorder;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        
        if (root == null) return preorder;
        stk.push(root);
        while (!stk.isEmpty()) {
            root = stk.pop();
            preorder.add(root.val);
            if (root.right != null) stk.push(root.right);
            if (root.left != null) stk.push(root.left);
        }
        return preorder;
    }

    // LC 145 Postorder Traversal
    List<Integer> postorder = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            postorder.add(root.val);
        }
        return postorder;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        
        if (root == null) return postorder;
        stk.push(root);
        while (!stk.isEmpty()) {
            root = stk.pop();
            postorder.add(root.val);
            if (root.left != null) stk.push(root.left);
            if (root.right != null) stk.push(root.right);
        }
        return postorder.reversed();
    }

    // LC 226 Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode leftInvert = invertTree(root.left);
            TreeNode rightInvert = invertTree(root.right);
            root.left = rightInvert;
            root.right = leftInvert;
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            Deque<TreeNode> qu = new ArrayDeque<>();

            qu.offer(root);
            while (!qu.isEmpty()) {
                TreeNode cur = qu.poll();
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                if (cur.left != null) qu.offer(cur.left);
                if (cur.right != null) qu.offer(cur.right);
            }
        }
        return root;
    }

    // LC 104 Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        int maxDepthVal = 0;
        if (root != null) {
            maxDepthVal = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return maxDepthVal;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<Pair<TreeNode, Integer>> stk = new ArrayDeque<>();
        stk.push(new Pair<>(root, 1));

        int maxDepth = 0;
        while (!stk.isEmpty()) {
            Pair<TreeNode, Integer> pair = stk.pop();
            TreeNode node = pair.key;
            int curDepth = pair.value;
            maxDepth = Math.max(maxDepth, curDepth);

            if (node.left != null) stk.push(new Pair<>(node.left, curDepth + 1));
            if (node.right != null) stk.push(new Pair<>(node.right, curDepth + 1));
        }
        return maxDepth;
    }

    class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // LC 100. Same Tree
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    class Pair {
        TreeNode first;
        TreeNode second;
        Pair(TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(p, q));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node1 = pair.first;
            TreeNode node2 = pair.second;

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;
            stack.push(new Pair(node1.right, node2.right));
            stack.push(new Pair(node1.left, node2.left));
        }
        return true;
    }

    // LC 102. Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        Deque<TreeNode> qu = new ArrayDeque<>();

        qu.offer(root);
        while (!qu.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int curLevelLen = qu.size(), itr = 0;
            while (itr < curLevelLen) {
                TreeNode cur = qu.poll();
                curLevel.add(cur.val);
                if (cur.left != null) qu.offer(cur.left);
                if (cur.right != null) qu.offer(cur.right);
                itr++;
            }
            levels.add(curLevel);
        }
        return levels;
    }

    List<List<Integer>> levels;
    public List<List<Integer>> levelOrder(TreeNode root) {
        levels = new ArrayList<>();
        if (root == null) return levels;
        dfsHelper(root, 0);
        return levels;
    }

    private void dfsHelper(TreeNode node, int level) {
        if (levels.size() == level) levels.add(new ArrayList<>());
        levels.get(level).add(node.val);
        if (node.left != null) dfsHelper(node.left, level + 1);
        if (node.right != null) dfsHelper(node.right, level + 1);
    }
    
    // LC 199. Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) return rightView;
        Deque<TreeNode> qu = new ArrayDeque<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int levelSize = qu.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = qu.poll();
                if (i == levelSize - 1) rightView.add(curNode.val);
                if (curNode.left != null) qu.offer(curNode.left);
                if (curNode.right != null) qu.offer(curNode.right);
            }            
        }
        return rightView;
    }

    // LC 103. Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        boolean leftToRight = true;        
        Deque<TreeNode> qu = new ArrayDeque<>();
        
        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = qu.peek();
                if (cur.left != null) qu.offer(cur.left);
                if (cur.right != null) qu.offer(cur.right);
                if (leftToRight) level.addLast(qu.poll().val);
                else level.addFirst(qu.poll().val);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }

    // LC 98. Validate Binary Search Tree
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return dfsInorder(root);
    }
    
    private boolean dfsInorder(TreeNode root) {
        if (root == null) return true;
        if (!dfsInorder(root.left)) return false;
        if (prev != null && prev.val >= root.val) return false;
        prev = root;
        return dfsInorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stk = new ArrayDeque<>();
        if (root == null) return true;
        TreeNode prev = null;
        while (!stk.isEmpty() || root != null) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }

    // LC 230. Kth Smallest Element in a BST
    List<Integer> bstInorderArr = new ArrayList<>();
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            bstInorderArr.add(root.val);
            inorder(root.right);
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return bstInorderArr.get(k - 1);
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }

    // LC 235. Lowest Common Ancestor of a Binary Search Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return root;
    }
}
