package com.algorithm.app;

public class Backtracking {

    // 17
    private List<String> combinations = new ArrayList<>();
    private String[] letters = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        backtrack(digits, new StringBuilder(), 0);
        return combinations;
    }

    private void backtrack(String digits, StringBuilder sBuilder, int startIdx) {
        if (sBuilder.length() == digits.length()) {
            combinations.add(sBuilder.toString());
            return;
        }

        String curLetters = letters[digits.charAt(startIdx) - '0'];
        for (char l : curLetters.toCharArray()) {
            sBuilder.append(l);
            backtrack(digits, sBuilder, startIdx + 1);
            sBuilder.deleteCharAt(sBuilder.length() - 1);
        }
    }
    
    // LC 131
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> curList, String s, int startIdx) {
        if (startIdx >= s.length())
            res.add(new ArrayList<>(curList));

        for (int i = startIdx; i < s.length(); i++) {
            if (isPalindrome(s, startIdx, i)) {
                curList.add(s.substring(startIdx, i + 1));
                backtrack(res, curList, s, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }
    
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
