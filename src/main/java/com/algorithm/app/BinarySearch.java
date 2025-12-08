package com.algorithm.app;

public class BinarySearch {

  // public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int count : piles) {
            right = Math.max(right, count);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int hoursSpent = 0;
            for (int count : piles) {
                hoursSpent += Math.ceil((double)count / mid);
            }
            if (hoursSpent <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
  public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int count : piles) {
            right = Math.max(right, count);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int hoursSpent = 0;
            for (int count : piles) {
                hoursSpent += Math.ceil((double)count / mid);
            }
            if (hoursSpent <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
  
  // LC 74
  public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        int midIdx, curElem;
        while (l <= r) {
            midIdx = (l + r) / 2;
            curElem = matrix[midIdx / n][midIdx % n];
            if (curElem < target) {
                l = midIdx + 1;
            } else if (curElem > target) {
                r = midIdx - 1;
            } else {
                return true;
            }
        }
        return false;
    }
  
  // LC 704
  public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
