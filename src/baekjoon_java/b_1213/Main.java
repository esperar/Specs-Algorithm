package baekjoon_java.b_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        char oneAlpha = ' ';
        int[] alpha = new int[26];
        int isOne = 0;

        for(int i = 0; i < input.length(); i++) {
            alpha[input.charAt(i) - 'A']++;
        }

        for(int i = 0; i < 26; i++) {
            if(alpha[i] % 2 != 0) {
                oneAlpha = (char) (i + 65);
                isOne++;
            }
        }


        if(isOne > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        String answer = "";
        // 시작 삽입
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char)(i + 65));
            }
        }

        answer += sb.toString();

        String end = sb.reverse().toString();
        // 중간 삽입
        if(oneAlpha != ' ') {
            answer += oneAlpha;
        }

        // 끝 삽입
        answer += end;

        System.out.println(answer);
    }

}
