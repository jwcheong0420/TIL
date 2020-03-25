package practice_coding.programmers.test_kit.greedy.joystick;

class Solution1 {
    public int solution(String name) {
        int len = name.length();
        int count = 0;
        int discount = 0;   // num of 'a' from 2nd index
        for (int i = 0; i < len; i++) {
            char ch = name.charAt(i);
            if (ch < 'N') {
                count += (ch - 'A');
            } else {
                count += ('Z' - ch + 1);
            }

            if (i > 0 && ch == 'A') {
                discount++;
            }
        }
        int answer = count + (len - 1 - discount);
        return answer;
    }
}