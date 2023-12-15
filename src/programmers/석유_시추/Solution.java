package programmers.석유_시추;

import java.util.*;

class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int n, m;
    int[][] land;
    int[][] oil;
    boolean[][] visited;

    public int solution(int[][] land) {
        this.land = land;
        this.n = land.length;
        this.m = land[0].length;
        this.oil = new int[n][m];
        this.visited = new boolean[n][m];

        int oilId = 0;
        Map<Integer, Integer> oilSize = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j, oilId);
                    oilSize.put(oilId, size);
                    oilId++;
                }
            }
        }

        int[] oilSum = new int[m];
        for (int j = 0; j < m; j++) {
            Set<Integer> oilSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (land[i][j] == 1) {
                    oilSet.add(oil[i][j]);
                }
            }
            for (int id : oilSet) {
                oilSum[j] += oilSize.get(id);
            }
        }

        return Arrays.stream(oilSum).max().getAsInt();
    }

    private int bfs(int x, int y, int oilId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        oil[x][y] = oilId;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    oil[nx][ny] = oilId;
                    size++;
                }
            }
        }

        return size;
    }
}