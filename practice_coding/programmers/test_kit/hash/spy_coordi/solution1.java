package practice_coding.programmers.test_kit.hash.spy_coordi;

import java.util.HashMap;

class Solution1 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> closet = new HashMap<>();
        for (String[] clothing : clothes) {
            closet.put(clothing[1], closet.getOrDefault(clothing[1], 0) + 1);
        }

        int answer = 1;
        for (Integer nums : closet.values()){
            answer *= nums + 1;
        }

        return answer - 1;
    }
}