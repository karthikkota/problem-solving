package com.algorithm.app;

public class Dynamic {

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
