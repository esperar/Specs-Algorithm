package baekjoon_java.b_15652;

import java.util.Scanner;

public class Main {

    static int[] arr;

    static int n,m;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        dfs(1, 0);
        System.out.println(sb);
    }

    static void dfs(int v, int depth) {
        if(depth == m) {
            for(int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = v; i <= n; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
