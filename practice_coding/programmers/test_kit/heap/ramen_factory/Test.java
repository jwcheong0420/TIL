package practice_coding.programmers.test_kit.heap.ramen_factory;

class Test {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = { 4, 10, 15 };
        int[] supplies = { 20, 5, 10 };
        int k = 30;

        Solution1 sol1 = new Solution1();
        int answer1 = sol1.solution(stock, dates, supplies, k);
        System.out.println("answer1 : " + answer1);
    }
}