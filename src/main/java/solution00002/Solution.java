package solution00002;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        int carryOver = 0;

        while (l1 != null || l2 != null || carryOver != 0) {
            int sum = value(l1) + value(l2) + carryOver;
            ListNode curr = new ListNode(sum % 10);
            carryOver = sum / 10;
            if (head == null) {
                head = curr;
            }
            if (last != null ) {
                last.next = curr;
            }
            last = curr;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head;
    }

    static int value(ListNode n) {
        if (n == null) {
            return 0;
        }
        return n.val;
    }
}
