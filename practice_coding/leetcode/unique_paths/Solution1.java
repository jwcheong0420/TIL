package practice_coding.leetcode.unique_paths;

class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m + 1][n + 1];
        calculate(m, n, map);
        return map[m][n];
    }

    public void calculate(int x, int y, int[][] map) {
        if (x == 1 || y == 1) {
            map[x][y] = 1;
        } else {
            if (map[x - 1][y] == 0) {
                calculate(x - 1, y, map);
            }
            if (map[x][y - 1] == 0) {
                calculate(x, y - 1, map);
            }
            map[x][y] = map[x - 1][y] + map[x][y - 1];
        }
    }
}