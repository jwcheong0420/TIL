package practice_coding.programmers.test_kit.heap.scoville;

import java.util.PriorityQueue;

class Solution2 {
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
}