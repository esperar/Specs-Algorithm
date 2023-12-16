package baekjoon_java.b_15651;

import java.util.Scanner;

public class Main {

    static int[] arr;
    static boolean[] visited;

    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == m) {
            for(int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}
