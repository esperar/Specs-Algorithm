package baekjoon_java.b_11725;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList<>();
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(1);
        for(int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int v) {
        visited[v] = true;
        for(int next : tree.get(v)) {
            if(!visited[next]) {
                parent[next] = v;
                dfs(next);
            }
        }
    }

}
