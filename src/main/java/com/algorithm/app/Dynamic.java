package com.algorithm.app;

public class Dynamic {
    
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
