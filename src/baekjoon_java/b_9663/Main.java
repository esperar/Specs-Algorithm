package baekjoon_java.b_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if(depth == n) {
            answer++;
            return;
        }

        for(int i = 0; i < n; i++) {
            board[depth] = i;
            if(isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean isPossible(int col) {
        for(int i = 0; i < col; i++) {
            if(board[col] == board[i]) {
                return false;
            } else if(Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
