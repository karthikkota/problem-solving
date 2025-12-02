package com.algorithm.app;

public class BinarySearch {

  // LC 74
  public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        int pivotIdx, pivotElement;
        while (l <= r) {
            pivotIdx = (l + r) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (pivotElement < target) {
                l = pivotIdx + 1;
            } else if (pivotElement > target) {
                r = pivotIdx - 1;
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
