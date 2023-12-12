package baekjoon_java.b_15649;

import java.util.Scanner;

public class Main {

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[M];
        visited = new boolean[N];
        dfs(N, M, 0);
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
        return;
    }
}
