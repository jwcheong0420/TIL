package practice_coding.programmers.test_kit.dfs_bfs.network;

import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer += find(computers, visited, i);
            }
        }
        return answer;
    }

    private int find(int[][] computers, boolean[] visited, int start){
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            for (int i = 0; i < visited.length; i++) {
                if (computers[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return 1;
    }
}