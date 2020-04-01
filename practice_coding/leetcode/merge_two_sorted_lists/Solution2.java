package practice_coding.leetcode.merge_two_sorted_lists;

class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode x = l1, y = l2, prev = dummyHead;
        while (x != null && y != null) {
            if (x.val < y.val) {
                prev.next = x;
                x = x.next;
            } else {
                prev.next = y;
                y = y.next;
            }
            prev = prev.next;
        }
        if (x == null && y != null) {
            prev.next = y;
        } else if (x != null && y == null) {
            prev.next = x;
        }
        return dummyHead.next;
    }
}