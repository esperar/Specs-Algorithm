package baekjoon_java.b_5568;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Set<String> set = new HashSet<>();
    static int n, k;
    static int[] cards;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        cards = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        dfs("", 0);
        System.out.println(set.size());
    }

    static void dfs(String num, int depth) {
        if(depth == k) {
            set.add(num);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(num + String.valueOf(cards[i]), depth + 1);
                visited[i] = false;
            }
        }
    }
}
