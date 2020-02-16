package practice_coding.programmers.test_kit.stack_queue.top;

import java.util.Arrays;

class Solution2 {
    public int[] solution(int[] heights) {
        final int topNum = heights.length;
        int[] answer = new int[topNum];

        for (int i = topNum - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] > heights[i]) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] heights = { 6, 9, 5, 7, 4 };

        int[] answer = sol.solution(heights);
        System.out.println("answer : " + Arrays.toString(answer));
    }
}