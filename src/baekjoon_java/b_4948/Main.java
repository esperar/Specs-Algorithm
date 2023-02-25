package baekjoon_java.b_4948;

import java.util.Scanner;

public class Main {
    public static boolean[] prime;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true){

            int N = input.nextInt();
            int count = 0;

            if(N == 0) break;

            prime = new boolean[N * 2 + 1];
            prime[0] = prime[1] = true;

            getPrime();

            for(int i = N + 1; i <= N * 2; i++){
                if(!prime[i])
                    count++;
            }

            System.out.println(count);
        }
    }

    public static void getPrime(){
        for(int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]) continue;
            for(int j = i*i ; j < prime.length; j += i){
                prime[j] = true;
            }
        }
    }
}
