package practice_coding.programmers.test_kit.heap.ramen_factory;

import java.util.PriorityQueue;

class Solution1 {
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
}