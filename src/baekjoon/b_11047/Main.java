package baekjoon.b_11047;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int money = sc.nextInt();
        int[] input = new int[N];

        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        int count = 0;

        for(int i = N - 1; i >= 0; i--){
            count += (money/input[i]);
            money = money - (money / input[i]) * input[i];
        }

        System.out.println(count);
    }
}
