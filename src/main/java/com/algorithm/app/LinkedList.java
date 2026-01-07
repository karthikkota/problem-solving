package com.algorithm.app;

public class LinkedList {
public boolean hasCycle(ListNode head) {
  if (head == null) return false;
  slowPtr = head;
  speedPtr = head;
  while (speedPtr != null) {
    if (slowPtr == speedPtr) return true;
    slowPtr = slowPtr.next;
    speedPtr = speedPtr.next.next;
  }
  return false;
}

}
