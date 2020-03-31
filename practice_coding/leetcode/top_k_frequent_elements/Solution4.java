package practice_coding.leetcode.top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution4 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int n : nums) {
            hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : hmap.keySet()) {
            int freq = hmap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && answer.size() < k; i--) {
            if (bucket[i] != null) {
                answer.addAll(bucket[i]);
            }

        }
        return answer;

    }
}