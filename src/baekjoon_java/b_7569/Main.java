package baekjoon_java.b_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] box;
    static int h, n, m;
    static Queue<Tomato3d> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        q.offer(new Tomato3d(i, j, k));
                    }
                }
            }
        }

        int result = bfs() - 1;

        LOOP: for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        result = -1;
                        break LOOP;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs() {
        int z = 0, x = 0, y = 0;
        int[] az = {-1, 0, 0, 0, 0, 1};
        int[] ay = {0, 0, 0, -1, 1, 0};
        int[] ax = {0, -1, 1, 0, 0, 0};

        while (!q.isEmpty()) {
            Tomato3d tomato = q.poll();
            z = tomato.z;
            x = tomato.x;
            y = tomato.y;

            for (int i = 0; i < 6; i++) {
                int nz = z + az[i];
                int nx = x + ax[i];
                int ny = y + ay[i];

                if (nx >= n || ny >= m || nz >= h || nx < 0 || ny < 0 || nz < 0) {
                    continue;
                }

                if (box[nz][nx][ny] == 0) {
                    q.offer(new Tomato3d(nz, nx, ny));
                    box[nz][nx][ny] = box[z][x][y] + 1;
                }
            }

        }

        return box[z][x][y];
    }

    static class Tomato3d {
        private int z;
        private int x;
        private int y;

        public Tomato3d(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

}

