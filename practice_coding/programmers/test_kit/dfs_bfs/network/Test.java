package practice_coding.programmers.test_kit.dfs_bfs.network;

class Test {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int correct = 2;

        Solution1 sol1 = new Solution1();
        int answer1 = sol1.solution(n, computers);
        assert answer1 != correct : "answer1 is not " + correct + ", " + answer1;

        Solution2 sol2 = new Solution2();
        int answer2 = sol2.solution(n, computers);
        assert answer2 != correct : "answer2 is not " + correct + ", " + answer2;
    }
}