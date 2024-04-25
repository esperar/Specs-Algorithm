package baekjoon_java.b_1783;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer;

        if(n == 1) {
            answer = 1;
        } else if(n == 2) {
            answer = Math.min(4, (m - 1) / 2 + 1);
        } else if(m < 7) {
            answer = Math.min(4, m);
        } else {
            answer = (2 + (m - 5)) + 1;
        }

        System.out.println(answer);
    }
}
