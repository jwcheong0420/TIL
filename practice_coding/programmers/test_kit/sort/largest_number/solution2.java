package practice_coding.programmers.test_kit.sort.largest_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution2 {
    public String solution(int[] numbers) {
        List<Integer> numList = new ArrayList<>();
        for (int num : numbers) {
            numList.add(num);
        }

        Collections.sort(numList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String num1 = o1.toString() + o2.toString();
                String num2 = o2.toString() + o1.toString();
                return num1.compareTo(num2) * (-1);
            }
        });

        String answer = "";
        for (Integer num : numList) {
            answer += num.toString();
        }

        return answer.charAt(0) == '0' ? "0" : answer;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] numbers = {3, 30, 34, 5, 9};
        // int[] numbers = {0, 0, 0, 0};

        String answer = sol.solution(numbers);
        System.out.println("answer : " + answer);
    }
}