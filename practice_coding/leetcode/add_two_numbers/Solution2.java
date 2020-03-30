package practice_coding.leetcode.add_two_numbers;

class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean up = false;
        int sum = l1.val + l2.val;
        if (sum >= 10) {
            up = true;
            sum %= 10;
        }
        ListNode answer = new ListNode(sum);
        ListNode prev = answer;
        while (l1.next != null || l2.next != null) {
            sum = 0;
            if (up) {
                sum++;
                up = false;
            }

            if (l1.next != null) {
                l1 = l1.next;
                sum += l1.val;
            }

            if (l2.next != null) {
                l2 = l2.next;
                sum += l2.val;
            }

            if (sum >= 10) {
                up = true;
                sum %= 10;
            }

            ListNode next = new ListNode(sum);
            prev.next = next;
            prev = next;
        }
        if (up) {
            ListNode next = new ListNode(1);
            prev.next = next;
        }

        return answer;
    }
}