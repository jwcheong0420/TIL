package practice_coding.programmers.test_kit.dp.int_triangle;

import java.util.Arrays;

class Solution1 {
    public int solution(int[][] triangle) {
        int level = triangle.length;

        for (int i = 1; i < level; i++) {
            int len = triangle[i].length;
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == len - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else if (triangle[i - 1][j - 1] > triangle[i - 1][j]) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += triangle[i - 1][j];
                }
            }
        }
        Arrays.sort(triangle[level - 1]);
        int len = triangle[level - 1].length;
        return triangle[level - 1][len - 1];
    }
}