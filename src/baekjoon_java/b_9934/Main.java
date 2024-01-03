package baekjoon_java.b_9934;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int k;
    static int[] arr;
    static StringBuilder[] answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        arr = new int[(int) Math.pow(2, k) - 1];

        answer = new StringBuilder[k];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < k; i++) {
            answer[i] = new StringBuilder();
        }

        search(0, arr.length - 1, 0);

        for(int i = 0; i < k; i++) {
            System.out.println(answer[i].toString());
        }
    }

    private static void search(int s, int e, int depth) {

        if(depth == k) {
            return;
        }

        int m = (s + e) / 2;
        answer[depth].append(arr[m]).append(" ");

        search(s, m - 1, depth + 1);
        search(m + 1, e, depth + 1);
    }
}
