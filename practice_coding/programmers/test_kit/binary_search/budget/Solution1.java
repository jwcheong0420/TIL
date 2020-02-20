package practice_coding.programmers.test_kit.binary_search.budget;

import java.util.Arrays;

class Solution1 {
    public int solution(int[] budgets, int M) {
        int length = budgets.length;
        Arrays.sort(budgets);

        if (calcBudgetWithLimit(budgets, budgets[length - 1]) <= M) {
            return budgets[length - 1];
        }

        int answer = 0;
        int low = 0;
        int high = budgets[length - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = calcBudgetWithLimit(budgets, mid);
            if (sum > M) {
                high = mid - 1;
            } else {
                answer = mid > answer ? mid : answer;
                low = mid + 1;
            }
        }

        return answer;

    }

    private long calcBudgetWithLimit(int[] budgets, int limit) {
        long sum = 0;
        for (int budget : budgets) {
            if (budget <= limit) {
                sum += budget;
            } else {
                sum += limit;
            }
        }
        return sum;
    }
}