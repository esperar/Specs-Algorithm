package baekjoon_java.b_2512;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];

        int left = 0;
        int right = -1;
        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            right = Math.max(right, input[i]);
        }

        int m = sc.nextInt();

        while(left <= right) {
            int mid = (left + right) / 2;
            int cost = 0;
            for(int i = 0; i < n; i++) {
                cost += Math.min(input[i], mid);
            }

            if(cost <= m){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
