package baekjoon_java.b_5585;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 1000;
        int count = 0;
        int N = sc.nextInt();
        int[] m = {500 , 100, 50, 10, 5, 1};
        money = money - N;

        for(int i = 0; i < m.length; i++) {
            if(money >= m[i]){
                count += money / m[i];
                money = money % m[i];
            }

            if(money == 0){
                break;
            }
        }

        System.out.println(count);
    }
}
