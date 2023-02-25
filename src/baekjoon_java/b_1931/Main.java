package baekjoon_java.b_1931;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            time[i][0] = in.nextInt(); // 시작시간
            time[i][1] = in.nextInt(); // 종료시간
        }

        Arrays.sort(time, (o1, o2) -> {
            // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int prev_end_time = 0;

        for (int i = 0; i < N; i++) {
            if (prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
