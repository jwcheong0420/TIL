package practice_coding.programmers.test_kit.dp.tile;

class Solution1 {
    public long solution(int N) {
        long[] tiles = new long[N + 1];
        tiles[0] = 0;
        tiles[1] = 1;
        for (int i = 2; i <= N; i++) {
            tiles[i] = tiles[i - 2] + tiles[i - 1];
        }

        return 2 * tiles[N - 1] + 4 * tiles[N];
    }
}