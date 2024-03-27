package baekjoon_java.b_11000;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            arr[i][0] = s;
            arr[i][1] = t;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);
        for(int i = 1; i < n; i++) {
            if(pq.peek() <= arr[i][0]) {
                pq.poll();
            }

            pq.add(arr[i][1]);
        }

        System.out.println(pq.size());
    }
}
