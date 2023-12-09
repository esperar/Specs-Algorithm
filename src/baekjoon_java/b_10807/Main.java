package baekjoon_java.b_10807;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        for(int i = 0; i < n; i++) {
            if(target == arr[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
