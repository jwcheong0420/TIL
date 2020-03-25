package practice_coding.programmers.test_kit.greedy.joystick;

class Solution2 {
    public int solution(String name) {
        int len = name.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            char ch = name.charAt(i);
            if (ch < 'N') {
                count += (ch - 'A');
            } else {
                count += ('Z' - ch + 1);
            }
        }

        int startI = -1;
        int endI = -1;
        for (int i = 0; i < len; i++) {
            char chI = name.charAt(i);
            if (chI == 'A') {
                int j = i + 1;
                for (; j < len; j++ ){
                    if (name.charAt(j) != 'A') {
                        break;
                    }
                }
                if (startI == -1 || endI - startI < (j - 1) - i) {
                    startI = i;
                    endI = j - 1;
                }
            }
        }
        
        int cursor = 0;
        if (startI == -1) {
            // 순차적 ->
            cursor = len - 1;
        } else {
            int a = startI;
            int b = endI - startI + 1;
            int c = len - endI - 1;

            if (a == 0) {   // 무조건 <-
                if (b > 1) {
                    cursor = c;
                } else {
                    cursor = len - 1;
                }
            } else if (c == 0) {    // b 전까지만 ->
                cursor = a - 1;
            } else {
                if (a - b < 1) {    // 2(a - 1) + c < a + b + c - 1
                    cursor = 2 * (a - 1) + c;   // -> 했다가 <-
                } else {
                    cursor = len - 1;
                }
            }
        }
        int answer = count + cursor;
        return answer;
    }
}