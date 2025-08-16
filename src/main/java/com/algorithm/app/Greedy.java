package com.algorithm.app;

import java.util.Arrays;

public class Greedy {

    // LC 1013
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0, count = 0, curSum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 3 != 0) return false;

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            if (curSum == sum / 3) {
                count++;
                curSum = 0;
                if (count == 2 && i < arr.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // LC 1710
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] boxUnit : boxTypes) {
            int boxCount = Math.min(boxUnit[0], truckSize);
            res += boxCount * boxUnit[1];
            truckSize -= boxCount;
            if (truckSize == 0) break;
        }
        return res;
    }

}
