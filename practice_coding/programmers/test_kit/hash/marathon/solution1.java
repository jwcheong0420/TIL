package practice_coding.programmers.test_kit.hash.marathon;

import java.util.Arrays;

class Solution1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i=0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])){
                answer = participant[i];
                break;
            }
        }
        if (answer.isEmpty()){
            answer = participant[participant.length - 1];
        }

        return answer;
    }
}