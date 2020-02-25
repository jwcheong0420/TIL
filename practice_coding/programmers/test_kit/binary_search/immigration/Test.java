package practice_coding.programmers.test_kit.binary_search.immigration;

class Test {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        int correct = 28;

        Solution1 sol1 = new Solution1();
        long answer1 = sol1.solution(n, times);
        System.out.println("answer1 : " + answer1);
        assert answer1 != correct : "answer1 is not " + correct + ", " + answer1;
    }
}