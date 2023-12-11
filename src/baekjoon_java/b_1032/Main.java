package baekjoon_java.b_1032;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        String[] files = new String[n];

        for(int i = 0; i < n; i++) {
            files[i] = sc.next();
        }

        for(int i = 0; i < files[0].length(); i++) {
            boolean isSame = true;
            for(int j = 0; j < n - 1; j++) {
                if (files[j].charAt(i) != files[j + 1].charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if(isSame) {
                sb.append(files[0].charAt(i));
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb);
    }
}
