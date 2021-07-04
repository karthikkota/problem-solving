
class GreedyProblem {

    // LC 402, T-O(n), S-O(n)
    public String removeKdigits(String num, int k) {
        Deque<Character> stk = new ArrayDeque();

        for (char digit : num.toCharArray()) {
            while (stk.size() > 0 && k > 0 && stk.peek() > digit) {
                stk.pop();
                k--;
            }
            stk.push(digit);
        }

        for (int i = 0; i < k; i++) {
            stk.pop();
        }

        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;

        while (!stk.isEmpty()) {
            char digit = stk.removeLast();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            res.append(digit);
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}