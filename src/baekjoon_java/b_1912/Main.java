package baekjoon_java.b_1912;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[100001];
        int[] dp = new int[100001];

        for(int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
        }

        dp[1] = s[1];
        long answer = dp[1];

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(s[i], s[i] + dp[i - 1]);
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
