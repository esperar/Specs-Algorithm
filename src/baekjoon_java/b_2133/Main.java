package baekjoon_java.b_2133;

import java.util.Scanner;

public class Main {

    static int dp(int n) {
        int[] dp = new int[100];

        if(n == 0) {
            return 1;
        }

        if(n == 1) {
            return 0;
        }

        if(n == 2) {
            return 3;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        int result = 3 * dp(n - 2);
        for(int i = 3; i <= n; i++) {
            if(i % 2 == 0) {
                result += 2 * dp(n - i);
            }
        }
        dp[n] = result;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dp(n));
    }
}
