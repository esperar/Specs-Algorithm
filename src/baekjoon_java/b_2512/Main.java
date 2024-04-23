package baekjoon_java.b_2512;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];

        int inputSum = 0;
        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            inputSum += input[i];
        }

        int maxCost = sc.nextInt();

        // 상한값을 넣어야하는뎅

        if(maxCost >= inputSum) {
            System.out.println(Arrays.stream(input).max());
            return;
        }


    }
}
