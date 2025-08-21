package com.algorithm.app;

public class TwoPointers {
  
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
