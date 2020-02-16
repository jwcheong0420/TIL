package practice_coding.programmers.test_kit.sort.k_th_number;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int count = commands.length;
        int[] answer = new int[count];

        for (int i = 0; i < count; i++) {
            int[] splited = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(splited);
            answer[i] = splited[commands[i][2] - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = sol.solution(array, commands);
        System.out.println("answer : " + Arrays.toString(answer));
    }
}