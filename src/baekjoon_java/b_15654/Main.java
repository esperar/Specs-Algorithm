package baekjoon_java.b_15654;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int[] input;

    static int n, m;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        input = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        sort(input);

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

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = input[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
