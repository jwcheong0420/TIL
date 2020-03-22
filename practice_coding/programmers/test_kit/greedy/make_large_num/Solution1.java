package practice_coding.programmers.test_kit.greedy.make_large_num;

class Solution1 {
    public String solution(String number, int k) {
        int len = number.length();
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = number.charAt(i) - '0';
        }

        String answer = "";
        // find first max (index : 0 ~ k)
        int max = -1, index = -1;
        for (int i = 0; i <= k; i++) {
            if (max < num[i]) {
                max = num[i];
                index = i;
            }
        }
        answer += max;

        int count = index; // erased 0..(index-1)
        index++;
        while (count < k) {
            int min = 10;
            int min_index = -1;
            // find min (index : index ~ index + k - count)
            for (int i = index; i <= index + k - count && i < len; i++) {
                if (min > num[i]) {
                    min = num[i];
                    min_index = i;
                }
            }
            // add to answer until min
            for (int i = index; i < min_index; i++) {
                answer += num[i];
            }
            count++;
            index = min_index + 1;
        }
        
        // add last nums
        for (int i = index; i < len; i++) {
            answer += num[i];
        }
        
        return answer;
    }
}