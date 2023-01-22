package baekjoon.b_11660;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] answer = new int[M];
        int[][] A = new int[N+1][N+1];
        int[][] S = new int[N+1][N+1];

        // 원본 배열 입력
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 합 배열 저장
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j];
            }
        }

        // 출력
        for(int i = 0; i < M; i++) {
           int X = sc.nextInt();
           int Y = sc.nextInt();
           int X2 = sc.nextInt();
           int Y2 = sc.nextInt();

           answer[i] = S[X2][Y2] - S[X - 1][Y2] - S[X2][Y - 1] + S[X - 1][Y - 1];
        }

        for(int i = 0; i < M; i++) {
            System.out.println(answer[i]);
        }
    }

}
