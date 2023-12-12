package baekjoon_java.b_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String target = br.readLine();

        int size = input.length();
        int size2 = target.length();

        input = input.replace(target, "");

        System.out.println(input);
        System.out.println((size - input.length()) / size2);


    }
}
