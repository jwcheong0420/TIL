package practice_coding.programmers.test_kit.dfs_bfs.target_number;

class Solution2 {

    public int solution(int[] numbers, int target) {
        int answer = calc(numbers, target, 0, 0);
        return answer;
    }
    private int calc(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        } else {
            return calc(numbers, target, index + 1, sum + numbers[index]) + calc(numbers, target, index + 1, sum - numbers[index]);
        }
    }
}