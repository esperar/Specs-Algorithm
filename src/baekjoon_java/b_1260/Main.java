package baekjoon_java.b_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int start;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        visited = new boolean[1001];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }


        dfs(start);
        System.out.println();

        visited = new boolean[n + 1];

        bfs(start);

    }

    static void dfs(int v) {
        System.out.print(v + " ");
        visited[v] = true;

        for(int i = 1; i <= n; i++) {
            if(graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v);
        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            int next = queue.poll();

           for(int i = 1; i <= n; i++) {
               if(graph[next][i] == 1 && !visited[i]) {
                   queue.offer(i);
                   visited[i] = true;
                   System.out.print(i + " ");
               }
           }
        }
    }
}
