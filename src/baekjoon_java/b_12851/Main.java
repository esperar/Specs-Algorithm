package baekjoon_java.b_12851;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    
    static class Node {
        int x;
        int time;
        
        Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    static int n, k;
    static boolean[] visited;
    static final int max = 100000;
    static int min = 99999999;
    static int count = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
        System.out.println(count + 1);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n , 0));
        visited[n] = true;

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.x] = true;

            if(now.x == k) {
                if(min == now.time) count++;
                else min = Math.min(min, now.time);
            }

            if(now.x * 2 <= max && !visited[now.x * 2]) {
                queue.offer(new Node(now.x * 2, now.time + 1));
            }

            if(now.x + 1 <= max && !visited[now.x + 1]) {
                queue.offer(new Node(now.x + 1, now.time + 1));
            }

            if(now.x - 1 >= 0 && !visited[now.x - 1]) {
                queue.offer(new Node(now.x - 1, now.time + 1));
            }
        }
    }
}
