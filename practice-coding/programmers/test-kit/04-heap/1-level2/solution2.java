import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for (int s : scoville) {
            foods.offer(s);
        }

        int answer = 0;
        while (foods.size() > 1 && foods.peek() < K) {
            int first = foods.poll();
            int second = foods.poll();
            int blended = first + second * 2;
            foods.offer(blended);
            answer++;
        }

        return foods.peek() >= K ? answer : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] scoville = { 10, 2, 3, 9, 1, 12 };
        int K = 7;

        int answer = sol.solution(scoville, K);
        System.out.println("answer : " + answer);
    }
}