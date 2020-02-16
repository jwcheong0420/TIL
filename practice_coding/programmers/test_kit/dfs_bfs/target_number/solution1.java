package practice_coding.programmers.test_kit.dfs_bfs.target_number;

class Solution1 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        calc(numbers, 0, target, 0);
        return answer;
    }
    private void calc(int[] numbers, int idx, int target, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        } else {
            calc(numbers, idx+1, target, sum + numbers[idx]);
            calc(numbers, idx+1, target, sum - numbers[idx]);
        }
    }
}