package baekjoon_java.b_2839;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int count = 0;

        while(a > 0) {
             if(a % 5 == 0) {
                 a -= 5;
                 count++;
             }
             else {
                 a -= 3;
                 count++;
             }
        }

        if(a == 0)
            System.out.println(count);
        else
            System.out.println(-1);

    }
}
