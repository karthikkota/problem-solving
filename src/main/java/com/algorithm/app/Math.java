package com.algorithm.app;

import java.util.*;

public class Math {
  // LC 202
  public boolean isHappy(int n) {
	int slow = n;
	int fast = computeNext(n);
	while(slow != fast && fast != 1) {
		slow = computeNext(slow);
		fast = computeNext(computeNext(fast));
}
return fast == 1;
}

private int computeNext(int n) {
	int nextNum = 0;
	while (n > 0) {
		int digit = n % 10;
		n /= 10;
		nextNum += digit * digit;
}
return nextNum;
}

}
