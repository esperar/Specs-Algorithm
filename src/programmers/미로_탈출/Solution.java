package programmers.미로_탈출;

import java.util.*;

class Solution {

    static char[][] graph;
    static int n, m, answer = 0;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean lever = false;

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        graph = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                graph[i][j] = maps[i].charAt(j);
                if(graph[i][j] == 'S'){
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        bfs();

        return answer;
    }

    static void bfs(){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];

            if(!lever && graph[x][y] == 'L') {
                visited = new boolean[n][m];
                queue.clear();
                queue.offer(new int[]{x, y, count});
                visited[x][y] = true;
                lever = true;
            } else if(lever && graph[x][y] == 'E'){
                answer = count;
                return;
            }
            for(int i = 0;i < 4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(!visited[nx][ny] && graph[nx][ny] != 'X'){
                        queue.offer(new int[]{nx, ny, count + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        answer = -1;
        return;
    }
}