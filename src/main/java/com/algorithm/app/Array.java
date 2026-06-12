package com.algorithm.app;

import java.util.*;

public class Array {
    // 1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curCompl = target - nums[i];
            if (numIdxMap.containsKey(curCompl)) {
                return new int[] { i, numIdxMap.get(curCompl) };
            }
            numIdxMap.put(nums[i], i);
        }
        return new int[] {};
    }

    // 242. Valid Anagram
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0)
                return false;
        }
        return true;
    }

    // Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int n : nums) {
            if (!hashSet.add(n)) return true;
        }
        return false;
    }

    // 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int curProfit = prices[i] - minPrice;
            maxProfit = curProfit > maxProfit ? curProfit : maxProfit;
            minPrice = minPrice > prices[i] ? prices[i] : minPrice;
        }
        return maxProfit;
    }


    // 53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;
        for (int num : nums) {
            if (curSum < 0) curSum = num;
            else curSum += num;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
    
    // 167. Two Sum II - Input Array Is Sorted
    // Sort and 2 pointer
    private List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i);
            }            
        }
        return res;
    }

    private void twoSum(int[] nums, int startIdx) {
        int left = startIdx + 1, right = nums.length - 1;
        while (left < right) {
            int curSum = nums[startIdx] + nums[left] + nums[right];
            if (curSum < 0) {
                left++;
            } else if (curSum > 0) {
                right--;
            } else {
                res.add(List.of(nums[startIdx], nums[left++], nums[right--]));
                // ensure to skip duplicate values
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }

    // Sort and HashSet
    private List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((i == 0 || nums[i] != nums[i - 1]) && nums[i] <= 0) {
                twoSum(nums, i);
            }            
        }
        return res;
    }

    private void twoSum(int[] nums, int startIdx) {
        Set<Integer> seenCompl = new HashSet<>();
        for (int i = startIdx + 1; i < nums.length; i++) {
            int compl = (nums[startIdx] + nums[i]) * -1;
            if (seenCompl.contains(compl)) {
                res.add(Arrays.asList(nums[startIdx], nums[i], compl));
                // Ensure to skip duplicates
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            }
            seenCompl.add(nums[i]);
        }        
    }


    // 49. Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] charCountStr = new String[strs.length];
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            charCountStr[i] = convertStrToCharCount(strs[i]);
            if (!anagramMap.containsKey(charCountStr[i])) {
                anagramMap.put(charCountStr[i], new ArrayList<>());
            }
            anagramMap.get(charCountStr[i]).add(strs[i]);
        }
        return new ArrayList(anagramMap.values());
    }

    private String convertStrToCharCount(String s) {
        int[] charCount = new int[26];
        StringBuilder charCountBldr = new StringBuilder();
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int i : charCount) {
            charCountBldr.append("#").append(i);
        }
        return charCountBldr.toString();
    }

    // 347. Top K Frequent Elements
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> freqMap.get(n1) - freqMap.get(n2));

        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        for (int i : freqMap.keySet()) {
            minHeap.add(i);
            if (minHeap.size() > k) minHeap.poll();
        }
        
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    // 11. Container With Most Water
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, curArea);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
