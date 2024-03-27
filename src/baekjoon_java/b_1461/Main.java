package baekjoon_java.b_1461;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;
        int max = Integer.MIN_VALUE;

        ArrayList<Integer> pArr = new ArrayList<>();
        ArrayList<Integer> mArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if(max < Math.abs(input)) {
                max = Math.abs(input);
            }
            if (input < 0) {
                mArr.add(input);
            } else {
                pArr.add(input);
            }
        }

        Collections.sort(pArr, Collections.reverseOrder());
        Collections.sort(mArr);

        for(int i = 0; i < pArr.size(); i++) {
            if(i % m == 0 && pArr.get(i) == max) {
                answer += pArr.get(i);
            } else if(i % m == 0) {
                answer += (pArr.get(i) * 2);
            }
        }

        for(int i = 0; i < mArr.size(); i++) {
            if(i % m == 0 && Math.abs(mArr.get(i)) == max) {
                answer += (Math.abs(mArr.get(i)));
            } else if(i % m == 0) {
                answer += (Math.abs(mArr.get(i)) * 2);
            }
        }

        System.out.println(answer);
    }
}
