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

    // LC 1736
    public String maximumTime(String time) {
        char[] times = time.toCharArray();
        if (times[0] == '?')
            times[0] = (times[1] <= '3' || times[1] == '?') ? '2' : '1';

        if (times[1] == '?')
            times[1] = times[0] == '2' ? '3' : '9';

        if (times[3] == '?')
            times[3] = '5';

        if (times[4] == '?')
            times[4] = '9';
        return new String(times);
    }

    // LC 1903
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i > -1; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0)
                return num.substring(0, i+1);
        }
        return "";
    }

}
