package baekjoon_java.b_11053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sequence = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(sequence[j] < sequence[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int answer = -1;
        for(int i = 0; i < n; i++) {
            if(dp[i] > answer) {
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}
