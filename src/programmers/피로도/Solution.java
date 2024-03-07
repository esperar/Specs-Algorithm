package programmers.피로도;

public class Solution {

    static int answer;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(k, 0, dungeons);

        return answer;
    }

    static void dfs(int k, int count, int[][] dungeons) {
        if(count > answer) {
            answer = count;
        }

        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}