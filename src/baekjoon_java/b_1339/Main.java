package baekjoon_java.b_1339;

import java.util.*;

public class Main {

    static int N;
    static int[] arr = new int[26];

    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            String input = sc.next();
            for(int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                arr[c - 'A'] += (int)Math.pow(10, input.length() - j - 1);
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int turn = 25;
        while(arr[turn] != 0) {
            answer += arr[turn] * num;
            turn--;
            num--;
        }

        System.out.println(answer);
    }
}
