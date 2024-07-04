package programmers.리코쳇_로봇;

import java.util.*;

class Solution {

    static int n, m;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        int[][] visited = new int[n][m];
        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i].charAt(j) == 'R') {
                    queue.add(new Node(i, j));
                    visited[i][j] = 1;
                    break;
                }
            }
        }

        int answer = -1;
        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if(board[now.x].charAt(now.y) == 'G') {
                answer = visited[now.x][now.y] - 1;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                while(true) {
                    if(isInRange(nx, ny) && board[nx].charAt(ny) != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    } else {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }

                if(visited[nx][ny] == 0) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                }
            }
        }


        return answer;
    }

    public boolean isInRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
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