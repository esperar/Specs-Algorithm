package baekjoon_java.b_11404;

import java.util.Scanner;

public class Main {

    static int[][] arr;
    static final int INF = 9900001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                arr[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            arr[a - 1][b - 1] = Math.min(cost, arr[a - 1][b - 1]);
        }

        floydWarshall(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(arr[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void floydWarshall(int n) {
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                if(i == k) continue;;
                for(int j = 0; j < n; j++) {
                    if(i == j || j == k) continue;

                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
    }

}

