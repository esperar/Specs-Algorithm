package baekjoon_java.b_10159;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n, m;

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<Integer>[] graphASC = new ArrayList[n + 1];
        ArrayList<Integer>[] graphDESC = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            graphASC[i] = new ArrayList<>();
            graphDESC[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graphASC[a].add(b);
            graphDESC[b].add(a);
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int depth1 = dfs(i, graphASC, visited) - 1;

            visited = new boolean[n + 1];
            int depth2 = dfs(i, graphDESC, visited) - 1;
            System.out.println(n - depth1 - depth2 - 1);
        }
    }

    static int dfs(int cur, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[cur] = true;
        int totalDepth = 1;

        for(int i = 0; i < graph[cur].size(); i++) {
            int next = graph[cur].get(i);
            if(!visited[next]) {
                totalDepth += dfs(next, graph, visited);
            }
        }

        return totalDepth;
    }
}
