package baekjoon_java.b_1068;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int deleted;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int root = -1;
        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            if(p == -1) {
                root = i;
            } else {
                graph[i].add(p);
                graph[p].add(i);
            }
        }

        deleted = sc.nextInt();
        if(deleted == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(answer);
    }

    static void dfs(int v) {
        visited[v] = true;
        int nodes = 0;
        for(int cur : graph[v]) {
            if(cur != deleted && !visited[cur]) {
                nodes++;
                dfs(cur);
            }
        }

        if(nodes == 0) {
            answer++;
        }
    }
}
