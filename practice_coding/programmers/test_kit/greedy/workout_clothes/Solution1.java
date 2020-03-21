package practice_coding.programmers.test_kit.greedy.workout_clothes;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

class Solution1 {
    public int solution(int n, int[] lost, int[] reserve) {
        HashMap<Integer, Integer> clothes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            clothes.put(i, 1);
        }
        for (int r : reserve) {
            clothes.put(r, clothes.get(r) + 1);
        }
        for (int l : lost) {
            clothes.put(l, clothes.get(l) - 1);
        }

        Arrays.sort(lost);
        for (int l : lost) {
            if (clothes.get(l) > 0) {
                continue;
            }
            if (l > 1 && clothes.get(l - 1) == 2) {
                clothes.put(l, 1);
                clothes.put(l - 1, 1);
            } else if (l < n && clothes.get(l + 1) == 2) {
                clothes.put(l, 1);
                clothes.put(l + 1, 1);
            }
        }

        int answer = 0;
        for (int v : clothes.values()){
            if (v >= 1) {
                answer++;
            }
        }
        return answer;
    }
}