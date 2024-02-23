package baekjoon_java.b_15903;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] numbers = new long[n];

        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            Arrays.sort(numbers);
            long sum = numbers[0] + numbers[1];

            numbers[0] = sum;
            numbers[1] = sum;
        }

        System.out.println(Arrays.stream(numbers).sum());
    }
}
