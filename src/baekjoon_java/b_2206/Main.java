package baekjoon_java.b_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                int num = input.charAt(j) - '0';
                if(num == 1) {
                    map[i][j] = num;
                }
            }
        }

        if(n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int[][][] check = new int[2][n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        check[0][0][0] = 1;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            int w = now[0];
            int x = now[1];
            int y = now[2];

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if(nx >= n || ny >= m || nx < 0 || ny < 0) continue;

                if(map[nx][ny] == 0) {
                    if(check[w][nx][ny] == 0) {
                        queue.offer(new int[] {w, nx, ny});
                        check[w][nx][ny] = check[w][x][y] + 1;
                        if(nx == n - 1 && ny == m - 1) return check[w][nx][ny];
                    }
                } else {
                    if(w == 0 && (check[1][nx][ny] == 0)) {
                        queue.offer(new int[]{1, nx, ny});
                        check[1][nx][ny] = check[0][x][y] + 1;
                        if(nx == n - 1 && ny == m - 1) return check[1][nx][ny];

                    }
                }
            }
        }

        return -1;
    }

}
