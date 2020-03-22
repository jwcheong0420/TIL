package practice_coding.programmers.test_kit.greedy.make_large_num;

import java.util.Stack;

class Solution2 {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        int count = 0, index = 0;
        for (; index < number.length(); index++) {
            while (!stack.isEmpty() && stack.peek() < number.charAt(index) && count < k) {
                stack.pop();
                count++;
            }
            stack.push(number.charAt(index));
        }
        while (stack.size() > number.length() - k) {
            stack.pop();
        }

        String answer = "";
        for (int i = 0; i < number.length() - k; i++) {
            answer = stack.pop() + answer;
        }
        return answer;
    }
}