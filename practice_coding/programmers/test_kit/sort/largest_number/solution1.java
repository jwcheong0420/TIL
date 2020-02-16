package practice_coding.programmers.test_kit.sort.largest_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private class Num implements Comparable<Num> {
        String numStr;
        Num (int num) {
            this.numStr = String.valueOf(num);
        }

        @Override
        public int compareTo(Num o) {

            if (this.numStr.length() == o.numStr.length()) {
                return this.numStr.compareTo(o.numStr) * (-1);
            } else {
                String num1 = this.numStr + o.numStr;
                String num2 = o.numStr + this.numStr;
                return num1.compareTo(num2) * (-1);
            }
        }
    }

    public String solution(int[] numbers) {
        List<Num> numList = new ArrayList<>();
        for (int num : numbers) {
            numList.add(new Num(num));
        }
        Collections.sort(numList);


        String answer = "";
        for (Num num : numList) {
            answer += num.numStr;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {3, 30, 34, 5, 9};

        String answer = sol.solution(numbers);
        System.out.println("answer : " + answer);
    }
}