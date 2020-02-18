package practice_coding.programmers.test_kit.dfs_bfs.target_word;

class Test {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int correct = 4;

        Solution1 sol1 = new Solution1();
        int answer1 = sol1.solution(begin, target, words);
        System.out.println("answer1 : " + answer1);
        assert answer1 != correct : "answer1 is not " + correct + ", " + answer1;
    }
}