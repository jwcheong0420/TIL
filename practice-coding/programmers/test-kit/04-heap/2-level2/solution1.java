import java.util.PriorityQueue;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int flourAmount = stock;

        PriorityQueue<Integer> supplyCandidates = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;
        while (flourAmount < k) {
            while (i < dates.length && dates[i] <= flourAmount) {
                supplyCandidates.offer(supplies[i]);
                i++;
            }

            flourAmount += supplyCandidates.poll();
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int stock = 4;
        int[] dates = { 4, 10, 15 };
        int[] supplies = { 20, 5, 10 };
        int k = 30;

        int answer = sol.solution(stock, dates, supplies, k);
        System.out.println("answer : " + answer);
    }
}