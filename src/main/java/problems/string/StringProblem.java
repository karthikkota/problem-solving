
class StringProblem {

    // LC 5, T-O(n^2), S-O(1)
    public String longestPalindrome(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            String oddLenS = expandFromCenter(s, i - 1, i + 1);
            String evenLenS = expandFromCenter(s, i, i + 1);

            String maxLenS = oddLenS.length() > evenLenS.length() ? oddLenS : evenLenS;
            res = res.length() > maxLenS.length() ? res : maxLenS;
        }

        return res;
    }

    private String expandFromCenter(String s, int leftIdx, int rightIdx) {
        while (leftIdx > -1 && rightIdx < s.length() && s.charAt(leftIdx) == s.charAt(rightIdx)) {
            leftIdx--;
            rightIdx++;
        }

        leftIdx = leftIdx < 0 ? 0 : leftIdx + 1;
        rightIdx = rightIdx >= s.length() ? s.length() : rightIdx;

        return s.substring(leftIdx, rightIdx);
    }
}