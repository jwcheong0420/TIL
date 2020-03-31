package practice_coding.leetcode.top_k_frequent_elements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution3 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int n : nums) {
            hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return hmap.get(n2) - hmap.get(n1); // 내림차순
            }
        });
        for (int n : hmap.keySet()) {
            pq.offer(n);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            answer.add(pq.poll());
        }
        return answer;

    }
}