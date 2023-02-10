package baekjoon.b_2581;

import java.util.Scanner;

public class Main {

    public static boolean prime[];

    public static void getPrime() {
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int end = input.nextInt();
        int result = 0;
        Integer min = Integer.MAX_VALUE;

        prime = new boolean[end + 1];
        getPrime();

        for(int i = start; i <= end; i++){
            if(!prime[i]){
                result += i;
                if(min == Integer.MAX_VALUE){
                    min = i;
                }
            }
        }

        if(result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
            System.out.println(min);
        }
    }

}
