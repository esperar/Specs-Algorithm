package programmers.네트워크;


public class Solution {

    static int answer = 0;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, computers, n);
                answer++;
            }
        }

        return answer;
    }

    static void dfs(int start, int[][] computers, int n) {
        visited[start] = true;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && computers[start][i] == 1 && start != i) {
                dfs(i, computers, n);
            }
        }
    }
}