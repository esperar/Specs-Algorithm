package baekjoon_java.b_2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] numbersMap;
    static Set<String> numberSet;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberSet = new HashSet<>();
        numbersMap = new int[5][5];
        arr = new int[6];

        for(int i = 0; i < 5; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                numbersMap[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(i, j, 1);
            }
        }

        System.out.println(numberSet.size());
    }

    static void dfs(int x, int y, int depth) {
        // dfs를 도는데 depth가 6 보다 크다면

        if(depth > 6) {
            StringBuilder sb = new StringBuilder();
            // 6개가 만들어졌다는 거니까
            // numberSet에 넣는다.

            for(int number : arr) {
                sb.append(number);
            }

            numberSet.add(sb.toString());
            return;
        }
        arr[depth - 1] = numbersMap[x][y];

        for(int  i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, depth + 1);
            }
        }
    }
}
