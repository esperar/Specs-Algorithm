package baekjoon_java.b_11057;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long answer = 0;

        long[][] dp = new long[n + 1][10];

        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }


        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[1].length; j++) {
                answer += dp[i][j];
            }
        }

        System.out.println(answer % 10007);
    }
}
