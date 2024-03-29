package baekjoon_java.b_15686;

import java.util.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> house = new ArrayList<>();
    static boolean[] chickenVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1){
                    house.add(new Node(i, j));
                } else if(arr[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        chickenVisited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int count, int index) {
        if(count == m) {
            int total = 0;
            for(int i = 0; i < house.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++) {
                    if(chickenVisited[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);
                        sum = Math.min(sum, distance);
                    }
                }
                total += sum;
            }
            answer = Math.min(total, answer);
            return;
        }

        for(int i = index; i < chicken.size(); i++) {
            if(!chickenVisited[i]) {
                chickenVisited[i] = true;
                dfs(count + 1, i + 1);
                chickenVisited[i] = false;
            }
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
