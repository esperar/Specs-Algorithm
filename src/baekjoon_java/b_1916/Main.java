package baekjoon_java.b_1916;

import java.util.*;

public class Main {

    static class Node {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] visited = new boolean[n + 1];
        int[] result = new int[n + 1];
        List<Node>[] list = new List[n + 1];

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            list[a].add(new Node(b, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(!visited[now.end]) {
                visited[now.end] = true;
            }

            if(now.weight > result[now.end]) continue;

            for(int i = 0; i < list[now.end].size(); i++) {
                Node next = list[now.end].get(i);


                if(!visited[next.end] && next.weight + now.weight < result[next.end]) {
                    result[next.end] = next.weight + now.weight;
                    queue.add(new Node(next.end, result[next.end]));
                }
            }
        }

        System.out.println(result[end]);
    }
}
