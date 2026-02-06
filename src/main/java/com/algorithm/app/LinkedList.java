package com.algorithm.app;

public class LinkedList {

  // LC 2
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode();
        ListNode cur = tempHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int curSum = l1Val + l2Val + carry;
            carry = curSum / 10;
            cur.next = new ListNode(curSum % 10);
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            cur = cur.next;
        }
        return tempHead.next;
    }

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
