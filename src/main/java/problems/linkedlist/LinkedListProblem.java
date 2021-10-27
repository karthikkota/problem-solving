
class LinkedListProblem {

    // LC 138, T-O(N), S-O(1)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node nxt = cur;
        Node newNd = cur;

        // Insert new nodes in between existing
        while (cur != null) {
            nxt = cur.next;
            newNd = new Node(cur.val);
            cur.next = newNd;
            newNd.next = nxt;
            cur = cur.next.next;
        }

        // Connect random
        cur = head;
        while (cur != null) {
            nxt = cur.next;
            if (cur.random != null) {
                nxt.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // Separate new linked list
        cur = head;
        newNd = head.next;
        while (cur != null && cur.next != null) {
            nxt = cur.next;
            cur.next = cur.next.next;

            if (nxt.next != null) {
                nxt.next = nxt.next.next;
            } else {
                nxt.next = null;
            }
            cur = cur.next;
        }

        return newNd;
    }

    // LC 2, T-O(N), S-O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Ptr = l1;
        ListNode l2Ptr = l2;
        ListNode res = new ListNode();
        ListNode cur = res;
        int carry = 0;

        while (l1Ptr != null || l2Ptr != null) {
            int sum = carry;

            if (l1Ptr != null) sum += l1Ptr.val;
            if (l2Ptr != null) sum += l2Ptr.val;

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1Ptr != null) l1Ptr = l1Ptr.next;
            if (l2Ptr != null) l2Ptr = l2Ptr.next;
        }

        if (carry > 0) cur.next = new ListNode(carry);
        return res.next;
    }

    public static double[] findAverages(int K, int[] arr) {
        double[] res = new double[arr.length];
        int resPrt = 0;
        int left = 0;
        int right = K - 1;

        int curSum = 0;
        for (int i = left; i <= right; i++) {
            curSum += arr[i];
        }

        while (right < arr.length) {
            res[resPtr++] = curSum / K;
            left++;
            right++;

            if (right < arr.length) {
                curSum += arr[right];
            }
        }
        return res;
    }
}