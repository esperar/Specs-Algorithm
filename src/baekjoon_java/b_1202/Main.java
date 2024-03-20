package baekjoon_java.b_1202;

import java.util.*;

public class Main {

    static class Gem {
        int m;
        int v;

        Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Gem> gemList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int m = sc.nextInt();
            int v = sc.nextInt();
            gemList.add(new Gem(m, v));
        }
        gemList.sort(Comparator.comparingInt(n -> n.m));

        int[] weight = new int[K];
        for(int i = 0; i < K; i++) {
            weight[i] = sc.nextInt();
        }
        Arrays.sort(weight);

        long total = 0;
        int index = 0;
        PriorityQueue<Gem> queue = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        for(int i = 0; i < K; i++) {
            while(index < N && gemList.get(index).m <= weight[i]) {
                queue.add(gemList.get(index++));
            }

            if(!queue.isEmpty()) {
                total += queue.poll().v;
            }
        }
        System.out.println(total);
    }
}
