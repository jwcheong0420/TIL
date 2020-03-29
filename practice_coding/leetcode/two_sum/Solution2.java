package practice_coding.leetcode.two_sum;

import java.util.HashMap;

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (hmap.containsKey(tmp)) {
                return new int[]{hmap.get(tmp), i};
            } else {
                hmap.put(nums[i], i);
            }
        }
        return new int[0];
    }
}