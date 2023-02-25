package baekjoon_java.b_2751;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = input.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(input.nextInt());
        }

        Collections.sort(arr);

        for (Integer value : arr) {
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }
}
