package baekjoon_java.b_16401;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        long answer = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        long left = 1;
        long right = arr[n - 1];
        while(left <= right) {
            int count = 0;
            long mid = (left + right) / 2;
            for(int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }
            if(count >= m) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
