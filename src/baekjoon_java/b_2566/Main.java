package baekjoon_java.b_2566;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] array = new int[9][9];
        int max = 0;
        int index1 = 0;
        int index2 = 0;

        // 입력
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                array[i][j] = input.nextInt();
                if(array[i][j] > max) {
                    max = array[i][j];
                    index1 = i;
                    index2 = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((index1 + 1) + " " + (index2 + 1));

    }
}
