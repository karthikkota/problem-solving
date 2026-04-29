package com.algorithm.app;

public class Backtracking {

    // LC 79
    private char[][] board;
    private int rowCount;
    private int colCount;

    public boolean exist(char[][] board, String word) {
        this.rowCount = board.length;
        this.colCount = board[0].length;
        this.board = board;
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (backtrack(row, col, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int startIdx) {
        if (startIdx >= word.length())
            return true;
        if (row < 0 ||
                col < 0 ||
                row >= rowCount ||
                col >= colCount ||
                board[row][col] != word.charAt(startIdx))
            return false;

        board[row][col] = '#';
        if (backtrack(row + 1, col, word, startIdx + 1) ||
                backtrack(row - 1, col, word, startIdx + 1) ||
                backtrack(row, col + 1, word, startIdx + 1) ||
                backtrack(row, col - 1, word, startIdx + 1)) {
            return true;
        }
        board[row][col] = word.charAt(startIdx);
        return false;
    }
    
    // LC 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), finalList, target, 0);
        return finalList;
    }

  private void backtrack(int[] candidates, List<Integer> curList, List<List<Integer>> finalList, int target,
            int startIdx) {
        if (target == 0) {
            finalList.add(new ArrayList<Integer>(curList));
            return;
        }

        if (target < 0)
            return;

        for (int i = startIdx; i < candidates.length; i++) {
            if (candidates[i] > target)
                break;
            if (i > startIdx && candidates[i] == candidates[i - 1])
                continue;
            curList.add(candidates[i]);
            backtrack(candidates, curList, finalList, target - candidates[i], i + 1);
            curList.remove(curList.size() - 1);
        }
    }

  // LC 46
  public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private void backtrack(int[] nums, List<Integer> curList, List<List<Integer>> permutations) {
        if (curList.size() == nums.length) {
            permutations.add(new ArrayList<>(curList));
            return;
        }

        for (int n : nums) {
            if (curList.contains(n))
                continue;
            curList.add(n);
            backtrack(nums, curList, permutations);
            curList.remove(curList.size() - 1);
        }
    }
}
