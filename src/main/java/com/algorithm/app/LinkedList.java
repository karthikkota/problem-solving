package com.algorithm.app;

public class LinkedList {

  // LC 19
  public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(-1), left = preHead, right = preHead;
        preHead.next = head;
        for (int pos = 0; pos <= n; pos++) {
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return preHead.next;
    }
  
  // LC 21
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1), cur = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;
        return preHead.next;
    }
  
  // LC 206
  public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
  
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
