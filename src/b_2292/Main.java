package b_2292;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        a--;
        int count=1;

        while(a>0){
            a-=count*6;
            count++;
        }

        System.out.println(count);
    }
}
