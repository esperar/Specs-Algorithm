package baekjoon_java.b_11659;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int answer[] = new int[M];
        int[] A = new int[N];
        int[] S = new int[N];

        // 입력받기
        for (int i = 0; i < N; i++) {
            A[i] = input.nextInt();
        }
        S[0] = A[0];
        //구간 합 구하기
        for(int i = 1; i < N; i++) {
            S[i] = S[i-1] + A[i];
        }

        for(int k = 0; k < M; k++) {
            int i = input.nextInt() - 1;
            int j = input.nextInt() - 1;

            if(i == 0)
                answer[k] = S[j];
            else
                answer[k] = S[j] - S[i - 1];
        }

        for(int i = 0; i < M; i++) {
            System.out.println(answer[i]);
        }

     }
}
