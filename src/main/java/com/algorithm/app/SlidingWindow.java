package com.algorithm.app;

import java.util.*;

public class SlidingWindow {

  // LC 53. Maximum Subarray
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;
        for (int num : nums) {
            if (curSum < 0) curSum = num;
            else curSum += num;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    // LC 209. Minimum Size Subarray Sum
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, curSum = 0, minLen = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum >= target) {
                minLen = Math.min(right - left + 1, minLen);
                curSum -= nums[left++];              
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // Example: Given an array of positive integers nums and an integer k,
    // find the length of the longest subarray whose sum is less than or equal to k.
    public int findLength(int[] nums, int k) {
        int left = 0, right = 0, cur = 0, maxLen = 0;

        for (right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
        }
        return maxLen;
    }

    // Example 2: You are given a binary string s (a string containing only "0" and "1").
    // You may choose up to one "0" and flip it to a "1".
    // What is the length of the longest substring achievable that contains only "1"?
    public int findLength(String s) {
        int left = 0, right = 0, curLen = 0, maxLen = Integer.MIN_VALUE;

        for (right = 0; right < s.length(); right++) {
            if (s.charAt(right) == "0") {
                curLen++;
            }
            
            while (curLen > 1) {
                if (s.charAt(left) == '0') curLen--;
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
        }
        return maxLen;
    }

    // 713. Subarray Product Less Than K
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        
        int left = 0, right = 0, curProd = 1, res = 0;
        for (right = 0; right < nums.length; right++) {
            curProd *= nums[right];
            while (curProd >= k) {
                curProd /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }

    // Given an integer array nums and an integer k,
    // find the sum of the subarray with the largest sum whose length is k.
    public int findBestSubarray(int[] nums, int k) {
        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur += nums[i];
        }

        int res = cur;
        for (int i = k; i < nums.length; i++) {
            cur += nums[i] - nums[i - k];
            res = Math.max(res, cur);
        }
        return res;
    }
}
