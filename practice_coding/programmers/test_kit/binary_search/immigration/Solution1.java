package practice_coding.programmers.test_kit.binary_search.immigration;

import java.util.Arrays;

class Solution1 {
    public long solution(int n, int[] times) {
        long longN = (long) n;
        long[] longTimes = new long[times.length];
        for (int i = 0; i < longTimes.length; i++) {
            longTimes[i] = (long) times[i];
        }
        Arrays.sort(longTimes);

        long left = 1, right = longN * longTimes[times.length - 1];
        long answer = right;
        while (left <= right) {
            long tmpN = 0;
            long mid = (left + right) / 2;
            for (int i = 0; i < times.length; i++) {
                tmpN += mid / times[i];
            }

            if (tmpN < n) {
                left = mid + 1;
            } else {
                if (answer > mid) {
                    answer = mid;
                }
                right = mid - 1;
            }
        }
        return answer;
    }
}