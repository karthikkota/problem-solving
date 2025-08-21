package com.algorithm.app;

public class Array {

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
