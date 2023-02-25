package baekjoon_java.b_2750;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<Integer> list = new HashSet<>();
        for(int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        list.stream().sorted().forEach(System.out::println);
    }
}
