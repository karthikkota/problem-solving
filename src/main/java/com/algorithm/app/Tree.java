package com.algorithm.app;

public class Tree {
    // LC 938
    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        Deque<TreeNode> stk = new ArrayDeque();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            if (cur != null) {
                if (low <= cur.val && cur.val <= high)
                    res += cur.val;
                if (low < cur.val && cur.left != null)
                    stk.push(cur.left);
                if (cur.val < high && cur.right != null)
                    stk.push(cur.right);
            }
        }
        return res;
    }
    
    // LC 897
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(0);
        cur = res;
        rightOnlyInorderTree(root);
        return res.right;
    }

    private void rightOnlyInorderTree(TreeNode root) {
        if (root == null)
            return;

        rightOnlyInorderTree(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        rightOnlyInorderTree(root.right);
    }
    
    // LC 617 Iterative
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        Deque<TreeNode[]> stk = new ArrayDeque();
        stk.push(new TreeNode[] { root1, root2 });

        while (!stk.isEmpty()) {
            TreeNode[] curPair = stk.pop();
            if (curPair[0] == null || curPair[1] == null)
                continue;
            curPair[0].val += curPair[1].val;

            if (curPair[0].left == null)
                curPair[0].left = curPair[1].left;
            else
                stk.push(new TreeNode[] { curPair[0].left, curPair[1].left });

            if (curPair[0].right == null)
                curPair[0].right = curPair[1].right;
            else
                stk.push(new TreeNode[] { curPair[0].right, curPair[1].right });
        }
        return root1;
    }
    
    // LC 590 Iterative
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList();
        Deque<Node> stk = new ArrayDeque();
        if (root == null) return res;

        stk.push(root);
        while (!stk.isEmpty()) {
            Node cur = stk.pop();
            res.add(cur.val);
            for (Node c : cur.children) {
                stk.push(c);
            }
        }
        Collections.reverse(res);
        return res;
    }
    
    // LC 501 Iterative
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> freqC = new HashMap();
        Deque<TreeNode> stk = new ArrayDeque();
        stk.push(root);
        int modeCount = 0;

        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            freqC.put(cur.val, freqC.getOrDefault(cur.val, 0) + 1);
            if (cur.left != null)
                stk.push(cur.left);
            if (cur.right != null)
                stk.push(cur.right);
        }

        List<Integer> res = new ArrayList();
        for (int i : freqC.keySet()) {
            modeCount = Math.max(modeCount, freqC.get(i));
        }

        for (int i : freqC.keySet()) {
            if (freqC.get(i) == modeCount)
                res.add(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // LC 404 Iterative
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> stk = new ArrayDeque();
        stk.add(root);

        while (!stk.isEmpty()) {
            TreeNode curN = stk.pop();
            if (curN != null && curN.left != null && curN.left.left == null && curN.left.right == null) {
                sum += curN.left.val;
            }

            if (curN.left != null)
                stk.push(curN.left);
            if (curN.right != null)
                stk.push(curN.right);
        }
        return sum;
    }
    
    // LC 270 Iterative
    public int closestValue(TreeNode root, double target) {
        Stack<TreeNode> stk = new Stack();
        long prev = Long.MIN_VALUE;

        while (!stk.isEmpty() || root != null) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();

            if (prev <= target && target < root.val)
                return Math.abs(prev - target) <= Math.abs(root.val - target) ? (int) prev : root.val;

            prev = root.val;
            root = root.right;
        }
        return (int) prev;
    }
    
    // LC 257 Iterative
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        if (root == null) return paths;

        LinkedList<TreeNode> stk = new LinkedList();
        LinkedList<String> pth = new LinkedList();
        stk.push(root);
        pth.push(Integer.toString(root.val));
        TreeNode node;
        String path;

        while(!stk.isEmpty()) {
            node = stk.pop();
            path = pth.pop();
            if (node.left == null && node.right == null) paths.add(path);
            if (node.left != null) {
                stk.add(node.left);
                pth.add(path + "->" + Integer.toString(node.left.val));
            }

            if (node.right != null) {
                stk.add(node.right);
                pth.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        
    // LC 226 Iterative
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> qu = new LinkedList();
        qu.add(root);

        while (!qu.isEmpty()) {
            TreeNode cur = qu.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null)
                qu.add(cur.left);
            if (cur.right != null)
                qu.add(cur.right);
        }
        return root;
    }
    
    // LC 145 Iterative
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;

        TreeNode prevNode = null;
        Stack<TreeNode> stk = new Stack();

        while (root != null || !stk.isEmpty()) {
            if (root != null) {
                stk.push(root);
                root = root.left;
            } else {
                root = stk.peek();
                if (root.right == null || root.right == prevNode) {
                    res.add(root.val);
                    stk.pop();
                    prevNode = root;
                    root = null;
                } else {
                    root = root.right;
                }
            }
        }
        return res;
    }
    
    // LC 144 Iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack();
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;

        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stk.add(cur.right);
            }

            if (cur.left != null) {
                stk.add(cur.left);
            }
        }
        return res;
    }
    
    // LC 111 Iterative
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int qSize = q.size();
            while (qSize > 0) {
                qSize--;
                TreeNode node = q.remove();
                if (node == null) continue;

                if (node.left == null && node.right == null) return depth;
                q.add(node.left);
                q.add(node.right);
            }
            depth++;
        }
        return -1;
    }
    
    // LC 104 Iterative
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Stack<Pair<TreeNode, Integer>> stk = new Stack();
        stk.push(new Pair(root, 1));

        int maxDepth = 0;
        while (!stk.isEmpty()) {
            Pair<TreeNode, Integer> pair = stk.pop();
            TreeNode node = pair.key;
            int currDepth = pair.value;
            maxDepth = Math.max(maxDepth, currDepth);

            if (node.left != null) {
                stk.push(new Pair(node.left, currDepth + 1));
            }

            if (node.right != null) {
                stk.push(new Pair(node.right, currDepth + 1));
            }
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
    
    // LC 101 Iterative
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            if (n1 == null && n2 == null)
                continue;
            if (n1 == null || n2 == null)
                return false;
            if (n1.val != n2.val)
                return false;
            q.add(n1.left);
            q.add(n2.right);
            q.add(n1.right);
            q.add(n2.left);
        }
        return true;
    }
    
    // LC 94 Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stk = new Stack();
        TreeNode cur = root;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    
    // LC 997
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1)
            return -1;

        int[] trustR = new int[n + 1];
        for (int[] r : trust) {
            trustR[r[0]]--;
            trustR[r[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustR[i] == n - 1)
                return i;
        }
        return -1;
    }
    
    // LC 2689
    StringBuilder res = new StringBuilder();
    public char getKthCharacter(RopeTreeNode root, int k) {
        buildVals(root);
        return res.charAt(k - 1);
    }

    private void buildVals(RopeTreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.append(root.val);
        buildVals(root.left);
        buildVals(root.right);
    }
    
    // LC 2331
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0)
            return false;
        if (root.val == 1)
            return true;

        boolean leftEval = evaluateTree(root.left);
        boolean rightEval = evaluateTree(root.right);

        if (root.val == 2)
            return leftEval || rightEval;
        return leftEval && rightEval;
    }
    
    // LC 590
    public List<Integer> postorder(Node root) {
        List<Integer> vals = new ArrayList();
        postorder(root, vals);
        return vals;
    }

    private void postorder(Node root, List<Integer> vals) {
        if (root!=null) {
            for (Node n : root.children) {
                postorder(n, vals);
            }
            vals.add(root.val);
        }
    }
    
    // LC 965
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)  return false;
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null)  return true;
        if (root.val != val)  return false;
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }
    
    // LC 589
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        preorder(root, list);
        return list;
    }

    private void preorder(Node root, List<Integer> values) {
        if (root == null)
            return;

        values.add(root.val);
        for (Node n : root.children) {
            preorder(n, values);
        }
    }
    
    // LC 404
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
    
    // LC 700
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }

    // LC 257
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        buildPaths(root, res, "");
        return res;
    }

    private void buildPaths(TreeNode root, List<String> res, String path) {
        if (root == null)
            return;

        path += path == "" ? root.val : "->" + root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }

        buildPaths(root.left, res, path);
        buildPaths(root.right, res, path);
    }
    
    // LC 222
    public int countNodes(TreeNode root) {
        if (root == null)
          return 0;
        return 1 + countNodes(root.right) + countNodes(root.left);
    }
    
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
