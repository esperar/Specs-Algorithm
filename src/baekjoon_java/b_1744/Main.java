package baekjoon_java.b_1744;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> p = new ArrayList<>();
        List<Integer> m = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if(input <= 0) {
                m.add(input);
            } else {
                p.add(input);
            }
        }

        int sum = 0;

        p.sort(Collections.reverseOrder());
        Collections.sort(m);

        int i = 0;
        while(i < p.size()) {
            if(i + 1 < p.size() && p.get(i) != 1 && p.get(i + 1) != 1) {
                sum += p.get(i++) * p.get(i++);
            } else {
                sum += p.get(i++);
            }
        }

        i = 0;
        while(i < m.size()) {
            if (i + 1 < m.size()) {
                sum += m.get(i++) * m.get(i++);
            } else {
                sum += m.get(i++);
            }
        }

        System.out.println(sum);
    }
}
