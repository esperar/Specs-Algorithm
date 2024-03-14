package programmers.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int n;
    static int m;
    static int answer = -1;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] graph;
    static boolean[][] visited;

    static class Node {
        int x;
        int y;
        int depth;

        Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        graph = maps;
        visited = new boolean[n][m];

        return bfs(0, 0);
    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 1));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node target = queue.poll();

            if(target.x == n - 1 && target.y == m - 1) {
                answer = target.depth;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + target.x;
                int ny = dy[i] + target.y;

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(!visited[nx][ny] && graph[nx][ny] == 1) {
                    queue.add(new Node(nx, ny, target.depth + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return answer;
    }
}