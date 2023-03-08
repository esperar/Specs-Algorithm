package baekjoon_java.b_12891;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int S;
    static int P;
    static int answer;
    static String DNA;
    static HashMap<Character,int[]> hashMap = new HashMap<Character, int[]>();
    static char[] dna = {'A','C','G','T'};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int S = input.nextInt();
        int P = input.nextInt();
        DNA = input.next();

        for(char c : dna) {
            hashMap.put(c, new int[]{0, input.nextInt()});
        }

        for(int i = 0; i < P; i++) {
            hashMap.get(DNA.charAt(i))[0]++;
        }

        if(isFull()) {
            answer++;
        }

        for(int i = 0; i < S - P; i++){
            hashMap.get(DNA.charAt(i))[0]--;
            hashMap.get(DNA.charAt(i + P))[0]++;
            if(isFull()) answer++;
        }
        System.out.println(answer);
    }

    public static boolean isFull(){
        for(char c: dna){
            if(hashMap.get(c)[0] < hashMap.get(c)[1]) return false;
        }
        return true;
    }
}
