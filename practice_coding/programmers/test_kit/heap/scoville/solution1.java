package practice_coding.programmers.test_kit.heap.scoville;

import java.util.PriorityQueue;

class Solution1 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for (int s : scoville) {
            foods.offer(s);
        }

        int answer = 0;
        while (foods.size() > 1) {
            if (foods.peek() >= K) {
                return answer;
            }

            int first = foods.poll();
            int second = foods.poll();
            int blended = first + second * 2;
            foods.offer(blended);
            answer++;
        }
        return -1;
    }
}