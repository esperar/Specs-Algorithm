package baekjoon_java.b_2002;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        HashMap<String, Integer> carMap = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String car = sc.next();
            carMap.put(car, i);
        }

        for(int i = 1; i <= n; i++) {
            String outCar = sc.next();

            for (String s : carMap.keySet()) {
                if (carMap.get(outCar) > carMap.get(s)) {
                    answer++;
                    break;
                }
            }
            carMap.remove(outCar);
        }

        System.out.println(answer);

    }
}
