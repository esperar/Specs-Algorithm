package baekjoon_java.b_10431;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 1; i <= t; i++) {
            int[] arr = new int[20];
            int count = 0;
            int cur = sc.nextInt();
            for(int j = 0; j < 20; j++) {
                arr[j] = sc.nextInt();
            }

            for(int j = 0; j < 20; j++) {
               for(int k = 0; k < j; k++) {
                   if(arr[j] < arr[k]) {
                       count++;
                   }
               }
            }
            System.out.println(i + " " + count);
        }
    }

}

