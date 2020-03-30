package practice_coding.leetcode.add_two_numbers;

class Solution3 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode x = l1, y = l2, prev = dummyHead;
        int carry = 0;
        while (x != null || y != null) {
            int sum = carry;
            if (x != null) {
                sum += x.val;
                x = x.next;
            }
            if (y != null) {
                sum += y.val;
                y = y.next;
            }

            carry = sum / 10;
            sum %= 10;

            ListNode tmp = new ListNode(sum);
            prev.next = tmp;
            prev = tmp;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}