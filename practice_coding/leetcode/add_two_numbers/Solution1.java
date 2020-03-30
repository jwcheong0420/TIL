package practice_coding.leetcode.add_two_numbers;

class Solution1 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = l1.val, num2 = l2.val;
        int i = 0;
        while (l1.next != null) {
            l1 = l1.next;
            num1 += l1.val * Math.pow(10, ++i);
        }
        i = 0;
        while (l2.next != null) {
            l2 = l2.next;
            num2 += l2.val * Math.pow(10, ++i);
        }

        int sum = num1 + num2;
        ListNode answer = new ListNode(sum % 10);
        ListNode prev = answer;
        while (sum / 10 != 0) {
            sum /= 10;
            ListNode next = new ListNode(sum % 10);
            prev.next = next;
            prev = next;
        }
        return answer;
    }
}