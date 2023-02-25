package baekjoon_java.b_2775;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] apt = new int[15][15]; // 아파트 2차원 배열 생성

        // 1호의 수와 0층 i호의 수 설정
        for(int i = 0; i < 15; i++) {
            apt[i][1] = 1; // i 층 1호
            apt[0][i] = i; // 0층 i호
        }

        for(int i = 1; i < 15; i++) {
            for(int j = 2; j < 15; j++) {
                apt[i][j] = apt[i][j-1] + apt[i-1][j];
            }
        }

        int T = input.nextInt();

        for(int i = 0; i < T; i++) {
            int k = input.nextInt();
            int n = input.nextInt();

            System.out.println(apt[k][n]);
        }

    }
}
