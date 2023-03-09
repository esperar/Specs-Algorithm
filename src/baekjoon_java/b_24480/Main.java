package baekjoon_java.b_24480;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int N, M, start, count = 1;
    static ArrayList<Integer> list[];
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        start = sc.nextInt();
        list = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            list[i].sort(Comparator.reverseOrder());
        }

        dfs(start);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void dfs(int start){
        visited[start] = count++;
        for(int n : list[start]){
            if(visited[n] > 0) {
                continue;
            }
            dfs(n);
        }
    }
}