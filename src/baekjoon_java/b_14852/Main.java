package baekjoon_java.b_14852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] d = new long[1000001][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d[0][0] = 1;
        d[1][0] = 2;
        d[2][0] = 7;
        d[2][1] = 0;
        System.out.println(dp(n));
    }
    static long dp(int n) {
        for(int i = 3; i <= n; i++) {
            d[i][1] = (d[i-3][0] + d[i-1][1]) % 1000000007;
            d[i][0] = (2 * d[i-1][0] + 3 * d[i-2][0] + 2 * d[i][1]) % 1000000007;
        }
        return d[n][0];
    }
}
