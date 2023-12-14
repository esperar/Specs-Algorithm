package baekjoon_java.b_2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n = 0;
    static int m = 0;
    static char[][] arr;
    static boolean[][] visited;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 'L') {
                    visited = new boolean[n][m];
                    int value = bfs(i, j);
                    result = Math.max(value, result);
                }
            }
        }

        System.out.println(result);
    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Node(x, y, 0));
        int max = 0;

        while(!queue.isEmpty()) {
            Node target = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = target.x + dx[i];
                int ny = target.y + dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] &&arr[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, target.count + 1));
                    max = Math.max(max, target.count + 1);
                }
            }
        }

        return max;
    }


}
