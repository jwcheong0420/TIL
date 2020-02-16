package practice_coding.programmers.test_kit.heap.scoville;

class Test {
    public static void main(String[] args) {
        int[] scoville = { 10, 2, 3, 9, 1, 12 };
        int K = 7;

        Solution1 sol1 = new Solution1();
        int answer1 = sol1.solution(scoville, K);
        System.out.println("answer1 : " + answer1);

        Solution2 sol2 = new Solution2();
        int answer2 = sol2.solution(scoville, K);
        System.out.println("answer2 : " + answer2);
    }
}