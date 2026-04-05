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
}
