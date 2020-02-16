package practice_coding.programmers.test_kit.dfs_bfs.network;

class Solution2 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                find(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }

    private void find(int[][] computers, boolean[] visited, int current){
        visited[current] = true;
        for (int i = 0; i < visited.length; i++) {
            if (computers[current][i] == 1 && !visited[i]){
                find(computers, visited, i);
            }
        }
    }
}