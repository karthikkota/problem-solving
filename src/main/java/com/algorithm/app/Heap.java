package com.algorithm.app;

public class Heap {

    // LC 621
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;

        for (char t : tasks) {
            freq[t - 'A']++;
            maxFreq = Math.max(maxFreq, freq[t - 'A']);
        }

        int cpuTime = (maxFreq - 1) * (n + 1);
        for (int f : freq) {
            if (f == maxFreq) cpuTime++;
        }
        return Math.max(cpuTime, tasks.length);
    }

    // LC 1046
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            maxHeap.add(s);
        }

        while (maxHeap.size() > 1) {
            int s1 = maxHeap.remove();
            int s2 = maxHeap.remove();
            if (s1 != s2) {
                maxHeap.add(s1 - s2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }
}
