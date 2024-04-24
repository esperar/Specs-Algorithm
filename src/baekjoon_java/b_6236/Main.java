package baekjoon_java.b_6236;

import java.util.Scanner;

public class Main {

    static int[] input;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[n];

        int left = 0;
        int right = 10_000 * 100_000;

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            left = Math.max(left, input[i]);
        }

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(m >= getWithdrawalCount(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static int getWithdrawalCount(int moneyAmount) {
        int count = 1;
        int money = moneyAmount;

        for(int i : input) {
            money -= i;
            if(money < 0) {
                count++;
                money = moneyAmount - i;
            }
        }
        return count;
    }
}
