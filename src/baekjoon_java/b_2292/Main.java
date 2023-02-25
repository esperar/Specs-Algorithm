package baekjoon_java.b_2292;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int count=1;
        a--;

        while(a>0){
            a-=count*6;
            count++;
        }

        System.out.println(count);
    }
}
