package practice_coding.programmers.test_kit.hash.marathon;

import java.util.HashMap;
import java.util.Map.Entry;

class Solution3 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String player : participant) {
            hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            hashMap.put(player, hashMap.get(player) - 1);
        }

        for (Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
            }
        }

        return answer;
    }
}