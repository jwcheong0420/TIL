package practice_coding.leetcode.merge_two_sorted_lists;

class Solution1 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode x = l1, y = l2;
        ListNode prev = dummyHead;
        while (x != null || y != null) {
            ListNode next;
            if (x == null) {
                next = new ListNode(y.val);
                y = y.next;
            } else if (y == null) {
                next = new ListNode(x.val);
                x = x.next;
            } else if (x.val > y.val) {
                next = new ListNode(y.val);
                y = y.next;
            } else {
                next = new ListNode(x.val);
                x = x.next;
            }
            prev.next = next;
            prev = next;
        }
        return dummyHead.next;
    }
}