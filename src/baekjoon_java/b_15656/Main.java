package baekjoon_java.b_15656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;

    static int[] arr;
    static int[] input;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        input = new int[n];

        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        dfs(0);

        System.out.println(sb.toString());
    }

    static void dfs(int depth) {
        if(depth == m) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            arr[depth] = input[i];
            dfs(depth + 1);
        }
    }
}
