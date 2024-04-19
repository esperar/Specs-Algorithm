package baekjoon_java.b_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Node {
        int end;
        int time;

        Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }

    static boolean[] visited;
    static int INF = 100_000;
    static int min = Integer.MAX_VALUE;
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[INF + 1];
        bfs();
        System.out.println(min);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.end] = true;

            if(now.end == k) {
                min = Math.min(now.time, min);
            }

            if(now.end * 2 <= INF && !visited[now.end * 2]) {
                visited[now.end * 2] = true;
                queue.add(new Node(now.end * 2, now.time + 1));
            }

            if(now.end + 1 <= INF && !visited[now.end + 1]) {
                visited[now.end + 1] = true;
                queue.add(new Node(now.end + 1, now.time + 1));
            }

            if(now.end - 1 >= 0 && !visited[now.end - 1]) {
                visited[now.end - 1] = true;
                queue.add(new Node(now.end - 1, now.time + 1));
            }
        }
    }

}
