package baekjoon_java.b_1238;


import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Main.Node o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static List<Node>[] nList;
    static List<Node>[] rList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        nList = new ArrayList[n + 1];
        rList = new ArrayList[n + 1];

        for(int i = 0; i < n + 1; i++) {
            nList[i] = new ArrayList<>();
            rList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            nList[from].add(new Node(to, cost));
            rList[to].add(new Node(from, cost));
        }

        int[] go = djikstra(nList, x);
        int[] back = djikstra(rList, x);

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            int dis = go[i] + back[i];

            if(dis > answer) {
                answer = dis;
            }
        }

        System.out.println(answer);
    }

    static int[] djikstra(List<Node>[] list, int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        queue.add(new Node(start, 0));
        dp[start] = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.cost > dp[now.end]) continue;

            for (int i = 0; i < list[now.end].size(); i++) {
                Node next = list[now.end].get(i);
                if (!visited[next.end] && now.cost + next.cost < dp[next.end]) {
                    dp[next.end] = now.cost + next.cost;
                    queue.add(new Node(next.end, dp[next.end]));
                }
            }
        }

        return dp;
    }

}
