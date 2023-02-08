package baekjoon.b_1541;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr1 = input.split("-");
        int[] plusArr = new int[arr1.length];
        int answer = 0;
        // 더하기 연산 처리
        for (int i = 0; i < arr1.length; i++) {

            int count = 0;
            String[] arr2 = arr1[i].split("\\+");

            for (int j = 0; j < arr2.length; j++) {
                count += Integer.parseInt(arr2[j]);
            }
            plusArr[i] = count;
        }
        answer = plusArr[0];
        // 더한 연산끼리 빼주기
        for (int i = 1; i < arr1.length; i++) {
            answer -= plusArr[i];
        }

        System.out.println(answer);
    }
}
