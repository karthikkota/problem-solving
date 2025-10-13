package com.algorithm.app;

public class Dynamic {

    // LC 5
    public String longestPalindrome(String s) {
        int end = 0, start = 0, maxLen = 1, n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
    
    // LC 392 DP
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (s.length() == 0)
            return true;
        int[][] mem = new int[sLen + 1][tLen + 1];
        for (int c = 1; c <= tLen; c++) {
            for (int r = 1; r <= sLen; r++) {
                if (s.charAt(r - 1) == t.charAt(c - 1))
                    mem[r][c] = mem[r - 1][c - 1] + 1;
                else
                    mem[r][c] = Math.max(mem[r][c - 1], mem[r - 1][c]);
            }

            if (mem[sLen][c] == sLen)
                return true;
        }
        return false;
    }
    
    // LC 392 2-pointer
    public boolean isSubsequence(String s, String t) {
        int left = 0, right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == s.length();
    }
    
    // LC 392 Recursive
    String source, target;
    int leftBound, rightBound;

    public boolean isSubsequence(String s, String t) {
        source = s; target = t;
        leftBound = s.length(); rightBound = t.length();
        return isSubsequence(0, 0);
    }

    private boolean isSubsequence(int left, int right) {
        if (left == leftBound)
            return true;
        if (right == rightBound)
            return false;

        if (source.charAt(left) == target.charAt(right))
            left++;
        right++;
        return isSubsequence(left, right);
    }
    
    // LC 118
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] mem = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i + 1];
        }
        return mem[n];
    }
    
    // LC 70
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] mem = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i + 1];
        }
        return mem[n];
    }
}
