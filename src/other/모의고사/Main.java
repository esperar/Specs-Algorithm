package other.모의고사;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] solutions = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int n = sc.nextInt();
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = sc.nextInt();
        }

        ArrayList<Integer> result = new ArrayList<>();

        int max = 0;
        for(int i = 0; i < 3; i++) {
            int collect = 0;
            for(int j = 0; j < n; j++) {
                if(answer[j] == solutions[i][j % solutions[i].length]) {
                    collect++;
                }
            }

            if(collect >= max) {
                max = collect;
                result.add(i + 1);
            }
        }

        int[] resultArr = result.stream().mapToInt(Integer::intValue).toArray();
        for(int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i]);
        }
    }
}
