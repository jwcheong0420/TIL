package practice_coding.programmers.test_kit.stack_queue.top;

import java.util.Arrays;
import java.util.Stack;

class Solution1 {
    public int[] solution(int[] heights) {
        final int topNum = heights.length;
        int[] answer = new int[topNum];
        Stack<Integer> stack = new Stack<>();
        for (int height : heights) {
            stack.push(height);
        }

        for (int i = topNum - 1; i >= 0; i--) {
            int height = stack.pop();

            int receivedTopIdx = -1;
            for (int j = stack.size() - 1; j >= 0; j--) {
                int receivedTopHeight = stack.get(j);
                if (height < receivedTopHeight) {
                    receivedTopIdx = j;
                    break;
                }
            }
            answer[i] = receivedTopIdx + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int[] heights = { 6, 9, 5, 7, 4 };

        int[] answer = sol.solution(heights);
        System.out.println("answer : " + Arrays.toString(answer));
    }
}