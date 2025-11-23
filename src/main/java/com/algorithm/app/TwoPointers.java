package com.algorithm.app;

public class TwoPointers {
  // LC 167
  public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int curSum = numbers[low] + numbers[high];
            if (curSum > target) {
                high--;
            } else if (curSum < target) {
                low++;
            } else {
                return new int[] { low + 1, high + 1 };
            }
        }
        return new int[] { -1, -1 };
    }
  
  // LC 922
  public int[] sortArrayByParityII(int[] nums) {
      int eIdx = 0, oIdx = 1;
      while (eIdx < nums.length && oIdx < nums.length) {
          if (nums[eIdx] % 2 == 1) {
              int temp = nums[eIdx];
              nums[eIdx] = nums[oIdx];
              nums[oIdx] = temp;
              oIdx += 2;
          } else {
              eIdx += 2;
          }
      }
      return nums;
    }
    
}
