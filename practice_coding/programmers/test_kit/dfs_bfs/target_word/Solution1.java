package practice_coding.programmers.test_kit.dfs_bfs.target_word;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution1 {
    public int solution(String begin, String target, String[] words) {
        if (!existsTarget(target, words)) {
            return 0;
        }

        int answer = bfs(begin, target, words);
        return answer;
    }

    private boolean existsTarget(String target, String[] words) {
        for (String word : words) {
            if (target.compareTo(word) == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean canChange(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    private int bfs(String begin, String target, String[] words) {
        Map<String, Integer> hash = new HashMap<>();
        Queue<String> q = new LinkedList<String>();
        q.offer(begin);
        hash.put(begin, 0);

        while (!q.isEmpty()) {
            String current = q.poll();
            int count = hash.get(current);
            for (String word : words) {
                if (!hash.containsKey(word) && canChange(current, word)) {
                    hash.put(word, count + 1);
                    if (target.compareTo(word) == 0) {
                        break;
                    } else {
                        q.offer(word);
                    }
                }
            }
        }
        return hash.getOrDefault(target, 0);
    }
}