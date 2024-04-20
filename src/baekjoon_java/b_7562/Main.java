package baekjoon_java.b_7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int l;
    static int startX, startY;
    static int endX, endY;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-2, -1, 2, 1, -2, -1, 2, 1};
    static int[] dy = {-1, -2, 1, 2, 1, 2, -1, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            l = sc.nextInt();
            map = new int[l][l];
            visited = new boolean[l][l];

            startX = sc.nextInt();
            startY = sc.nextInt();
            endX = sc.nextInt();
            endY = sc.nextInt();

            bfs(startX, startY);
            sb.append(map[endX][endY]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                if(visited[nx][ny]) continue;

                queue.add(new Node(nx, ny));
                map[nx][ny] = map[now.x][now.y] + 1;
                visited[nx][ny] = true;
            }
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
