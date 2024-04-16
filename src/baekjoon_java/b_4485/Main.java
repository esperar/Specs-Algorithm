package baekjoon_java.b_4485;


import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Main.Node o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static int[][] graph;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = -1;
        int idx = 1;
        while(true) {
            n = sc.nextInt();

            if(n == 0) {
                break;
            }

            graph = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            int cost = bfs();
            sb.append("Problem ")
                    .append(idx++)
                    .append(": ")
                    .append(cost)
                    .append("\n");
        }

        System.out.println(sb);
    }

    static int bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[][] move = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }

        queue.add(new Node(0, 0, graph[0][0]));
        move[0][0] = graph[0][0];

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(now.x == n - 1 && now.y == n - 1) {
                return now.cost;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if(now.cost + graph[nx][ny] < move[nx][ny]) {
                    move[nx][ny] = now.cost + graph[nx][ny];
                    queue.add(new Node(nx, ny, move[nx][ny]));
                }
            }
        }
        return -1;
    }
}
