package baekjoon_java.b_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V + 1];
        int[] result = new int[V + 1];
        List<Node>[] list = new List[V + 1];

        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        result[K] = 0;
        queue.add(new Node(K, 0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(!visited[now.end]) {
                visited[now.end] = true;
            }

            for(int i = 0; i < list[now.end].size(); i++) {
                Node next = list[now.end].get(i);
                if(!visited[next.end] && now.weight + next.weight < result[next.end]) {
                    result[next.end] = now.weight + next.weight;
                    queue.add(new Node(next.end, result[next.end]));
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if(result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }


}
