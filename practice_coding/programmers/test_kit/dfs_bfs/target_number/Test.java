package practice_coding.programmers.test_kit.dfs_bfs.target_number;

class Test {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int correct = 5;

        Solution1 sol1 = new Solution1();
        int answer1 = sol1.solution(numbers, target);
        assert answer1 != correct : "answer1 is not " + correct + ", " + answer1;

        Solution2 sol2 = new Solution2();
        int answer2 = sol2.solution(numbers, target);
        assert answer2 != correct : "answer2 is not " + correct + ", " + answer2;
    }
}