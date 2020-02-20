package practice_coding.programmers.test_kit.binary_search.budget;

class Test {
    public static void main(String[] args) {
        int[] budgets = {120, 110, 140, 150};
        int M = 485;

        int correct = 127;

        Solution1 sol1 = new Solution1();
        int answer1 = sol1.solution(budgets, M);
        System.out.println("answer1 : " + answer1);
        assert answer1 != correct : "answer1 is not " + correct + ", " + answer1;
    }
}