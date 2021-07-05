
class LinkedListProblem {

    // LC 138, T-O(n), S-O(1)
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
}