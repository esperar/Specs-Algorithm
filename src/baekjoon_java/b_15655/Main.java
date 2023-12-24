package baekjoon_java.b_15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;

    static int[] arr;
    static int[] input;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        arr = new int[m];
        input = new int[n];
        visited = new boolean[n];

        token = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(input);

        dfs(0, 0);

        System.out.println(sb.toString());
    }

    static void dfs(int at, int depth) {
        if(depth == m) {
            for(int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = at; i < n; i++) {
            arr[depth] = input[i];
            dfs(i + 1, depth + 1);
        }
    }
}
