package baekjoon_java.b_13164;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] members = new int[n];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            members[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i++) {
            list.add(members[i] - members[i - 1]);
        }

        Collections.sort(list);

        int answer = 0;

        for(int i = 0; i < n - k; i++) {
            answer += list.get(i);
        }

        System.out.println(answer);
    }

}
