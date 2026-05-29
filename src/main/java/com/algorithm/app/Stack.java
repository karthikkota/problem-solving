package com.algorithm.app;

public class Stack {

    // LC 739
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int curDay = 0; curDay < temperatures.length; curDay++) {
            int curTemp = temperatures[curDay];
            while (!stack.isEmpty() && temperatures[stack.peek()] < curTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = curDay - prevDay;
            }
            stack.push(curDay);
        }
        return answer;
    }

    // LC 150
    public int evalRPN(String[] tokens) {
        String operators = "*/+-";
        Stack<Integer> operandStk = new Stack<>();
        for (String s : tokens) {
            if (operators.contains(s)) {
                int operand2 = operandStk.pop();
                int operand1 = operandStk.pop();
                if (s.equals("*"))
                    operandStk.push(operand1 * operand2);
                if (s.equals("/"))
                    operandStk.push(operand1 / operand2);
                if (s.equals("+"))
                    operandStk.push(operand1 + operand2);
                if (s.equals("-"))
                    operandStk.push(operand1 - operand2);
            } else {
                operandStk.push(Integer.parseInt(s));
            }
        }
        return operandStk.pop();
    }
}
