package baekjoon_java.b_1389;

import java.util.Scanner;

public class Main {

    static int INF = 9999999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] friends = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                friends[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends[a - 1][b - 1] = 1;
            friends[b - 1][a - 1] = 1;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                }
            }
        }

        int temp = INF;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int total = 0;
            for(int j = 0; j < n; j++) {
                total += friends[i][j];
            }
            if(temp > total) {
                temp = total;
                answer = i + 1;
            }
        }

        System.out.println(answer);
    }
}
