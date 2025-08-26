package com.algorithm.app;

public class Array {

    // 747
    public int dominantIndex(int[] nums) {
        int largestNumIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[largestNumIdx])
                largestNumIdx = i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > nums[largestNumIdx] && i != largestNumIdx) {
                return -1;
            }
        }
        return largestNumIdx;
    }
    
    // LC 643
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - k + 1; i++) {
            int j = i;
            int curAvg = 0;
            while (j < k + i) {
                curAvg += nums[j++];
            }
            maxAvg = Math.max(curAvg, maxAvg);
        }
        return maxAvg / k;
    }
    
    // LC 575
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int uniqueCandyTypes = 1;
        Arrays.sort(candyType);

        for (int i = 1; i < n && uniqueCandyTypes < n / 2; i++) {
            if (candyType[i] != candyType[i - 1])
                uniqueCandyTypes++;
        }

        return Math.min(uniqueCandyTypes, n / 2);
    }
    
    // LC 500
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        List<String> res = new ArrayList<>();

        for (String w : words) {
            if (containsAllLetters(row1, w) || containsAllLetters(row2, w) || containsAllLetters(row3, w)) {
                res.add(w);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean containsAllLetters(String row, String word) {
        for (char c : word.toCharArray()) {
            if (!row.contains(String.valueOf(Character.toLowerCase(c)))) {
                return false;
            }
        }
        return true;
    }
}
