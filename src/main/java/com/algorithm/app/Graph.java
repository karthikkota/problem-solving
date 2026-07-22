package com.algorithm.app;

public class Graph {
  // 200. Number of Islands
    int rowCount, colCount;

    public int numIslands(char[][] grid) {
        rowCount = grid.length;
        colCount = grid[0].length;
        int islandCount = 0;
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c);
                }
            }
        }
        return islandCount;
    }

    void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= rowCount || c >= colCount || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

  // LE 133. Clone Graph
  public Node cloneGraph(Node node) {
        if (node == null) return node;
        HashMap<Node, Node> visited = new HashMap();
        Deque<Node> qu = new ArrayDeque<>();
        qu.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!qu.isEmpty()) {
            Node cur = qu.poll();
            for (Node neighbor : cur.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    qu.add(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
