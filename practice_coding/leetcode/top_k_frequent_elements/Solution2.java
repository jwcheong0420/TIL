package practice_coding.leetcode.top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution2 {
    class Number implements Comparable<Number> {
        int num;
        int count;

        Number(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Number n) {
            return n.count - this.count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int n : nums) {
            hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Number> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            pq.offer(new Number(entry.getKey(), entry.getValue()));
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            answer.add(pq.poll().num);
        }
        return answer;

    }
}