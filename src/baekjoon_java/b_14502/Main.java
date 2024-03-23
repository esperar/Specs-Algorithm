package baekjoon_java.b_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n, m;

    static int[][] arr;

    static int maxSafeZone = 0;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    static void dfs(int wall) {
        if(wall == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wall + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        int[][] copyArr = new int[n][m];

        for(int i = 0; i < n; i++) {
            copyArr[i] = arr[i].clone();
        }

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(copyArr[nx][ny] == 0) {
                        copyArr[nx][ny] = 2;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }

        int safeZone = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copyArr[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        if(maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }

    }
}
