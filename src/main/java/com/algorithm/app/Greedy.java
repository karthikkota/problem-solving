package com.algorithm.app;

import java.util.Arrays;

public class Greedy {

    // LC 860, modified
    public boolean lemonadeChange(int[] bills) {
        int fivedollorBills = 0, tendollorBills = 0;

        for (int i : bills) {
            if (i == 5)
                fivedollorBills++;
            if (i == 10)
                tendollorBills++;
        }

        for (int i : bills) {
            if (i == 10) {
                if (fivedollorBills == 0) {
                    return false;
                } else {
                    fivedollorBills--;
                }
            }

            if (i == 20) {
                if (fivedollorBills >= 3) {
                    fivedollorBills -= 3;
                } else if (tendollorBills >= 1 && fivedollorBills >= 1) {
                    tendollorBills--;
                    fivedollorBills--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    // LC 905
    public int[] sortArrayByParity(int[] nums) {
        int str = 0, end = nums.length - 1;
        while (str < end) {
            if (nums[str] % 2 > nums[end] % 2) {
                int temp = nums[str];
                nums[str] = nums[end];
                nums[end] = temp;
            }
            if (nums[str] % 2 == 0)
                str++;
            if (nums[end] % 2 > 0)
                end--;
        }
        return nums;
    }
    
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

    // LC 2078
    public int maxDistance(int[] colors) {
        int maxDict = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[colors.length - 1]) {
                maxDict = Math.max(maxDict, Math.abs(colors.length - 1 - i));
                break;
            }
        }

        for (int j = colors.length - 1; j > -1; j--) {
            if(colors[0] != colors[j]) {
                maxDict = Math.max(maxDict, j);
            }
        }
        return maxDict;
    }

    // LC 2259
    public String removeDigit(String number, char digit) {
        int indexToExclude = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                indexToExclude = i;
                if (i < number.length() - 1 && digit < number.charAt(i + 1))
                    break;
            }
        }
        return number.substring(0, indexToExclude) + number.substring(indexToExclude + 1, number.length());
    }

}
