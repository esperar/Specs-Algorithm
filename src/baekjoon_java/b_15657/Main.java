package baekjoon_java.b_15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[] input;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        input = new int[n];
        arr = new int[m];

        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        dfs(0, 0);

        System.out.println(sb.toString());
    }

    static void dfs(int at, int depth) {
        if(depth == m) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = at; i < input.length; i++) {
            arr[depth] = input[i];
            dfs(i, depth + 1);
        }
    }

}
