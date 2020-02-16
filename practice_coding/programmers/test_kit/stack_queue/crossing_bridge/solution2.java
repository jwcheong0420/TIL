package practice_coding.programmers.test_kit.stack_queue.crossing_bridge;

import java.util.LinkedList;
import java.util.Queue;

class Solution2{
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> crossing = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            crossing.offer(0);
        }

        int answer = 0, target = 0;
        while (target < truck_weights.length) {
            answer++;
            crossing.poll();

            int sumCrossingTrucks = crossing.stream().mapToInt(Integer::intValue).sum();
            if (sumCrossingTrucks + truck_weights[target] <= weight) {
                crossing.add(truck_weights[target++]);
            } else {
                crossing.add(0);
            }
        }
        return answer + bridge_length;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7, 4, 5, 6 };

        int answer = sol.solution(bridge_length, weight, truck_weights);
        System.out.println("answer : " + answer);
    }
}