package baekjoon_java.b_1244;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int gender = sc.nextInt();
            int start = sc.nextInt();

            if(gender == 1) {
                for(int j = 0; j < n; j++) {
                    if((j + 1) % start == 0) {
                        arr[j] = arr[j] == 0 ? 1 : 0;
                    }
                }

            } else {
                arr[start - 1] = arr[start - 1] == 0 ? 1 : 0;
                for(int j = 1; j < n / 2; j++) {

                    if(start - 1 + j >= n || start - 1 - j < 0) {
                        break;
                    }

                    if(arr[start - 1 - j] == arr[start - 1 + j]) {
                        arr[start - 1 - j] = arr[start - 1 - j] == 0 ? 1 : 0;
                        arr[start - 1 + j] = arr[start - 1 + j] == 0 ? 1 : 0;
                    } else {
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            if((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
