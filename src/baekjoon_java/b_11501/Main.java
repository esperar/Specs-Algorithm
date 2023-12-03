package baekjoon_java.b_11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] stocks;

        for(int t = 0; t < T; t++) {
            long answer = 0;
            int n = Integer.parseInt(br.readLine());
            stocks = new int[n];
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                stocks[i] = Integer.parseInt(token.nextToken());
            }
            int max = stocks[n - 1];

            for(int j = n - 2; j >= 0; j--) {
                if(stocks[j] <= max) {
                    answer += max - stocks[j];
                } else {
                    max = stocks[j];
                }
            }
            System.out.println(answer);
        }
        br.close();

    }
}
