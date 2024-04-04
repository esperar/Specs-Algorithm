package baekjoon_java.b_2607;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        String input = sc.next();

        for(int i = 0; i < n - 1; i++) {
            String currentStr = sc.next();
            int count = 0;
            int[] word = new int[26];

            for(int j = 0; j < input.length(); j++) {
                word[input.charAt(j) - 'A']++;
            }

            for(int j = 0; j < currentStr.length(); j++) {
                if(word[currentStr.charAt(j) - 'A'] > 0) {
                    count++;
                    word[currentStr.charAt(j) - 'A']--;
                }
            }

            if(input.length() == currentStr.length() && (input.length() == count || input.length() - 1 == count)) {
                answer++;
            } else if(input.length() == currentStr.length() - 1 && (currentStr.length() - 1 == count)) {
                answer++;
            } else if(input.length() == currentStr.length() + 1 && currentStr.length() == count) {
                answer++;
            }

        }

        System.out.println(answer);

    }
}
