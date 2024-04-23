package baekjoon_java.b_2805;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int left = 0;
        int right = -1;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }

        while(left <= right) {
            int mid = (left + right) / 2;
            long tree = 0;
            for(int i = 0; i < n; i++) {
                if(arr[i] > mid) {
                    tree += arr[i] - mid;
                }
            }

            if(tree >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
