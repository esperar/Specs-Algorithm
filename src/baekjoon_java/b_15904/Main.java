package baekjoon_java.b_15904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ucpc = { 'U', 'C', 'P', 'C' };
        String input = br.readLine();
        int index = 0;

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ucpc[index]) {
                index++;
            }

            if(index == 4) {
                System.out.println("I love UCPC");
                return;
            }
        }

        System.out.println("I hate UCPC");
    }
}
