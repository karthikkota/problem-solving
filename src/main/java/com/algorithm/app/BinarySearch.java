package com.algorithm.app;

public class BinarySearch {

    // LC sorted hash map
    HashMap<String, List<Pair<Integer, String>>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        hashMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!hashMap.containsKey(key) ||
                hashMap.get(key).get(0).getKey() > timestamp) {
            return "";
        }

        int left = 0, right = hashMap.get(key).size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hashMap.get(key).get(mid).getKey() <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return hashMap.get(key).get(right).getValue();
    }

    // LC 875
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int bananaCount : piles) {
            right = Math.max(right, bananaCount);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int hoursSpent = 0;
            for (int count : piles) {
                hoursSpent += Math.ceil((double) count / mid);
            }
            if (hoursSpent <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // LC 153
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
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
