package com.algorithm.app;

public class Array {

    // LC 238
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }
        return res;
    }
    
    // LC 347
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;

        Map<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> minFreqHeap = new PriorityQueue<>((n1, n2) -> hm.get(n1) - hm.get(n2));
        for (int n : hm.keySet()) {
            minFreqHeap.add(n);
            if (minFreqHeap.size() > k) minFreqHeap.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minFreqHeap.poll();
        }
        return res;
    }
    
    // LC 49
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List> anagramMap = new HashMap();
        for (String s : strs) {
            String charCountRep = formatToCharCount(s);
            if (!anagramMap.containsKey(charCountRep)) {
                anagramMap.put(charCountRep, new ArrayList());
            }
            anagramMap.get(charCountRep).add(s);
        }
        return new ArrayList(anagramMap.values());
    }

    private String formatToCharCount(String s) {
        int[] charCount = new int[26];
        StringBuilder sBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int i : charCount) {
            sBuilder.append(i).append("#");
        }
        return sBuilder.toString();
    }
    
    // LC 989
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int cur = k, i = num.length - 1;

        while (i > -1 || cur > 0) {
            if (i > -1)
                cur += num[i];
            res.add(cur % 10);
            cur /= 10;
            i--;
        }
        Collections.reverse(res);
        return res;
    }
    
    // LC 888
    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;

        Set<Integer> setB = new HashSet();
        for (int x: B) setB.add(x);
        for (int x: A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};
        throw null;
    }
    
    // LC 747
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
