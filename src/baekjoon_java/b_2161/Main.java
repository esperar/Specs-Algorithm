package baekjoon_java.b_2161;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        if(n == 1) {
            System.out.println(1);
            return;
        }

        for(int i = 1; i <= n; i++) {
            deque.add(i);
        }

        while(deque.size() > 1) {
            Integer first = deque.pop();
            sb.append(first).append(" ");

            Integer second = deque.pop();
            if(deque.isEmpty()) {
                sb.append(second).append(" ");
                break;
            } else {
                deque.offerLast(second);
            }
        }

        System.out.println(sb);
    }
}
