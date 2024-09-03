package baekjoon_java.b_1976;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] plan;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        plan = new int[m];
        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int input = sc.nextInt();
                if(input == 1) {
                    graph[i].add(j);
                }

                if(i == j) {
                    graph[i].add(j);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }

        for(int i = 0; i < m - 1; i++) {
            bfs(plan[i], plan[i + 1]);
        }

        System.out.println("YES");
    }

    static void bfs(int start, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            Integer now = queue.poll();
            for(int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if(next == dest) return;
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        System.out.println("NO");
        System.exit(0);
    }
}
