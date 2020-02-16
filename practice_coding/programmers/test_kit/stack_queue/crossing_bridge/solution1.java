package practice_coding.programmers.test_kit.stack_queue.crossing_bridge;

import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> crossing = new LinkedList<>();

        int answer = 0, target = 0;
        while (target < truck_weights.length) {
            answer++;
            if (crossing.size() == bridge_length) {
                crossing.poll();
            }

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
        Solution1 sol = new Solution1();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7, 4, 5, 6 };

        int answer = sol.solution(bridge_length, weight, truck_weights);
        System.out.println("answer : " + answer);
    }
}