package com.algorithm.app;

public class Array {

    // LC 2215
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        List<Integer> nums1Unq = new ArrayList<>();
        List<Integer> nums2Unq = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int n1 : nums1) {
            nums1Set.add(n1);
        }
        for (int n2 : nums2) {
            nums2Set.add(n2);
        }
        for (int n1 : nums1Set) {
            if (!nums2Set.contains(n1)) {
                nums1Unq.add(n1);
            }
        }
        for (int n2 : nums2Set) {
            if (!nums1Set.contains(n2)) {
                nums2Unq.add(n2);
            }
        }
        res.add(nums1Unq);
        res.add(nums2Unq);
        return res;
    }
    
    // LC 448
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curIdx = Math.abs(nums[i]) - 1;
            if (nums[curIdx] > 0)
                nums[curIdx] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }
    
    // LC 252
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0])
                return false;
        }
        return true;
    }
    
    // LC 219
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i]))
                return true;
            numSet.add(nums[i]);
            if (numSet.size() > k)
                numSet.remove(nums[i - k]);
        }
        return false;
    }
    
    // LC 169
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += n == candidate ? 1 : -1;
        }
        return candidate;
    }

    // 136
    public int singleNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int numsSum = 0, setSum = 0;
        for (int n : nums) {
            numsSum += n;
            if (!numSet.contains(n)) {
                numSet.add(n);
                setSum += n;
            }
        }
        return 2 * setSum - numsSum;
    }

    // 11
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left != right) {
            int len = right - left;
            int curHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(len * curHeight, maxArea);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    
    // LC 128
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int res = 0;

        for (int n : hashSet) {
            if (!hashSet.contains(n - 1)) {
                int curNum = n;
                int curStreak = 1;

                while (hashSet.contains(curNum + 1)) {
                    curNum += 1;
                    curStreak += 1;
                }

                res = Math.max(res, curStreak);
            }
        }

        return res;
    }
    
    // LC 238
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }
        return res;
    }
    
    // LC 347
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;

        Map<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> minFreqHeap = new PriorityQueue<>((n1, n2) -> hm.get(n1) - hm.get(n2));
        for (int n : hm.keySet()) {
            minFreqHeap.add(n);
            if (minFreqHeap.size() > k) minFreqHeap.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minFreqHeap.poll();
        }
        return res;
    }
    
    // LC 49
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List> anagramMap = new HashMap();
        for (String s : strs) {
            String charCountRep = formatToCharCount(s);
            if (!anagramMap.containsKey(charCountRep)) {
                anagramMap.put(charCountRep, new ArrayList());
            }
            anagramMap.get(charCountRep).add(s);
        }
        return new ArrayList(anagramMap.values());
    }

    private String formatToCharCount(String s) {
        int[] charCount = new int[26];
        StringBuilder sBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int i : charCount) {
            sBuilder.append(i).append("#");
        }
        return sBuilder.toString();
    }
    
    // LC 989
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int cur = k, i = num.length - 1;

        while (i > -1 || cur > 0) {
            if (i > -1)
                cur += num[i];
            res.add(cur % 10);
            cur /= 10;
            i--;
        }
        Collections.reverse(res);
        return res;
    }
    
    // LC 888
    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;

        Set<Integer> setB = new HashSet();
        for (int x: B) setB.add(x);
        for (int x: A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};
        throw null;
    }
    
    // LC 747
    public int dominantIndex(int[] nums) {
        int largestNumIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[largestNumIdx])
                largestNumIdx = i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > nums[largestNumIdx] && i != largestNumIdx) {
                return -1;
            }
        }
        return largestNumIdx;
    }
    
    // LC 643
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - k + 1; i++) {
            int j = i;
            int curAvg = 0;
            while (j < k + i) {
                curAvg += nums[j++];
            }
            maxAvg = Math.max(curAvg, maxAvg);
        }
        return maxAvg / k;
    }
    
    // LC 575
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int uniqueCandyTypes = 1;
        Arrays.sort(candyType);

        for (int i = 1; i < n && uniqueCandyTypes < n / 2; i++) {
            if (candyType[i] != candyType[i - 1])
                uniqueCandyTypes++;
        }

        return Math.min(uniqueCandyTypes, n / 2);
    }
    
    // LC 500
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        List<String> res = new ArrayList<>();

        for (String w : words) {
            if (containsAllLetters(row1, w) || containsAllLetters(row2, w) || containsAllLetters(row3, w)) {
                res.add(w);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean containsAllLetters(String row, String word) {
        for (char c : word.toCharArray()) {
            if (!row.contains(String.valueOf(Character.toLowerCase(c)))) {
                return false;
            }
        }
        return true;
    }
}
