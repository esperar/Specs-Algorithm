package baekjoon_java.b_2212;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if(k >= n) {
            System.out.println(0);
            return;
        }

        int[] sensors = new int[n];
        for(int i = 0; i < n; i++) {
            sensors[i] = sc.nextInt();
        }

        Arrays.sort(sensors);

        Integer[] distance = new Integer[n - 1];
        for(int i = 0; i < n - 1; i++) {
            distance[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(distance, Collections.reverseOrder());

        int answer = 0;

        for(int i = k - 1; i < n - 1; i++) {
            answer += distance[i];
        }


        System.out.println(answer);
    }
}
