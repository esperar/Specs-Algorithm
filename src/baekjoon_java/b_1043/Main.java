package baekjoon_java.b_1043;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> truthList;
    static int[] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parents = new int[n + 1];

        int answer = 0;

        for(int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int truth = sc.nextInt();
        if(truth == 0) {
            System.out.println(m);
            return;
        }

        truthList = new ArrayList<>();

        for(int i = 0; i < truth; i++) {
            truthList.add(sc.nextInt());
        }

        List<Integer>[] partyList = new ArrayList[m];
        for(int i = 0; i < m; i++) {
            partyList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int pn = sc.nextInt();
            int x = sc.nextInt();
            partyList[i].add(x);
            for(int j = 1; j < pn; j++) {
                int y = sc.nextInt();
                union(x, y);
                partyList[i].add(y);
            }
        }

        for(int i = 0; i < m; i++) {
            boolean flag = true;
            for(int num : partyList[i]) {
                if(truthList.contains(find(parents[num]))) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return find(parents[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if(truthList.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry =tmp;
        }

        parents[ry] = rx;
    }

}
