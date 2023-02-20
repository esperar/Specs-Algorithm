package baekjoon.b_25314;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for(int i = 0; i < N / 4; i++){
            System.out.print("long ");
        }

        System.out.println("int");
    }
}
