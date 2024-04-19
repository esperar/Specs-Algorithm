package baekjoon_java.b_1504;

import java.util.*;

public class Main {

    static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static int n, m;
    static List<Node>[] graph;

    final static int INF = 200_100_100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int distanceA = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int distanceB = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        int answer = (distanceA >= INF && distanceB >= INF) ? -1 : Math.min(distanceA, distanceB);
        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1.cost));
        int[] distance = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            distance[i] = INF;
        }

        queue.add(new Node(start, 0));
        distance[start] = 0;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if(distance[now.end] < now.cost) continue;

            for(Node next : graph[now.end]) {
                if(distance[next.end] > now.cost + next.cost) {
                    distance[next.end] = now.cost + next.cost;
                    queue.add(new Node(next.end, distance[next.end]));
                }
            }
        }

        return distance[end];
    }
}
