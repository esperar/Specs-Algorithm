package baekjoon.b_10986;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        long answer = 0;
        long[] S = new long[N]; // 구간합 배열
        long[] C = new long[M];

        S[0] = input.nextInt();
        for(int i = 1; i < N; i++) {
            S[i] = S[i-1] + input.nextInt();
        }

        for(int i = 0; i < N; i++) {
            int reminder = (int)(S[i] % M);
            if(reminder == 0)
                answer++;
            C[reminder]++;
        }

        for(int i = 0; i < M; i++) {
            if(C[i] > 1)
                answer = answer + (C[i] * (C[i] - 1) / 2);
        }

        System.out.println(answer);
    }
}
