package baekjoon_java.b_11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }
        int sum = 0;
        int result = 0;

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            result += sum + arr[i];

            sum += arr[i];
        }

        System.out.println(result);
    }
}
