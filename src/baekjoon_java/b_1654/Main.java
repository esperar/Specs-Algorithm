package baekjoon_java.b_1654;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[k];

        long left = 0;
        long right = -1;

        for(int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }
        right++;
        while(left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for(int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }

            if(count < n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }
}
