package practice_coding.programmers.test_kit.dp.int_triangle;

import java.util.Arrays;

class Solution2 {
    public int solution(int[][] triangle) {
        int level = triangle.length;

        for (int i = 1; i < level; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        Arrays.sort(triangle[level - 1]);
        return triangle[level - 1][level - 1];
    }
}