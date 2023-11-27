package baekjoon_java.b_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean visited[];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        parents = new int[n];

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        for(int i = 1; i < parents.length; i++) {
            sb.append(parents[i] + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int v) {
        visited[v] = true;
        for(int i : graph.get(v)) {
            if(!visited[i]) {
                parents[i - 1] = v;
                dfs(i);
            }
        }
    }
}
