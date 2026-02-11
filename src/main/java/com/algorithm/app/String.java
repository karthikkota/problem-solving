package com.algorithm.app;

public class String {

    // LC 5
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddPalinLen = computeLongestPalinLen(s, i, i);
            int evenPalinLen = computeLongestPalinLen(s, i, i + 1);
            int curLongestPalinLen = Math.max(oddPalinLen, evenPalinLen);
            if (curLongestPalinLen > right - left) {
                left = i - (curLongestPalinLen - 1) / 2;
                right = i + curLongestPalinLen / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int computeLongestPalinLen(String s, int left, int right) {
        while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    // LC 3
    public int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0;
        Map<Character, Integer> lastCharIndx = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            if (lastCharIndx.containsKey(curChar) && lastCharIndx.get(curChar) >= left) {
                left = lastCharIndx.get(curChar) + 1;
            }
            lastCharIndx.put(curChar, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
    
    // LC 246
    public boolean isStrobogrammatic(String num) {
        char[] rotatedNum = new char[]
        { '0', '1', '\0', '\0', '\0', '\0', '9', '\0', '8', '6', };
        StringBuilder rotatedStr = new StringBuilder();
        for (int i = num.length() - 1; i > -1; i--) {
            char rotatedCurChar = rotatedNum[Character.getNumericValue(num.charAt(i))];
            rotatedStr.append(rotatedCurChar);
        }
        return rotatedStr.toString().equals(num);
    }
    
    // LC 205
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stMap = new HashMap<Character, Character>();        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (stMap.containsKey(sChar) && stMap.get(sChar) != tChar) {
                return false;
            } else if (!stMap.containsKey(sChar) && stMap.containsValue(tChar)) {
                return false;
            } else if (!stMap.containsKey(sChar) && !stMap.containsValue(tChar)) {
                stMap.put(sChar, tChar);
            }
        }
        return true;
    }
    
    // LC 168
    public String convertToTitle(int columnNumber) {
        StringBuilder colTitle = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            colTitle.append((char)( 'A' + ((columnNumber) % 26)));
            columnNumber /= 26;
        }
        return colTitle.reverse().toString();
    }
    
    // LC 657
    public boolean judgeCircle(String moves) {
      int x = 0, y = 0;
      for (char m : moves.toCharArray()) {
          if (m == 'L') x--;
          if (m == 'R') x++;
          if (m == 'U') y++;
          if (m == 'D') y--;
        }
        return x == 0 && y == 0;
    }
}
