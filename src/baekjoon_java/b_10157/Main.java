package baekjoon_java.b_10157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(token.nextToken());
        int R = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(br.readLine());
        arr = new int[R + 2][C + 2];

        if((C * R) < K) {
            System.out.println(0);
            return;
        }

        for(int i = 0; i < (C + 2); i++) {
            arr[0][i] = -1;
            arr[R + 1][i] = -1;
        }

        for(int i = 0; i < (R + 2); i++) {
            arr[i][0] = -1;
            arr[i][C + 1] = -1;
        }

        int currentNumber = 1;
        int currentX = R;
        int currentY = 1;
        int dir = 0;

        while(true) {
            arr[currentX][currentY] = currentNumber;
            if(currentNumber == K) {
                System.out.println(currentY + " " + (R - currentX + 1));
                break;
            }

            if(arr[currentX + dx[dir]][currentY + dy[dir]] != 0) {
                dir = (dir + 1) % 4;
            }

            currentX += dx[dir];
            currentY += dy[dir];

            currentNumber++;

            if(currentNumber > C * R) {
                break;
            }
        }

    }
}
