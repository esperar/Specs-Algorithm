package baekjoon_java.b_10162;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> buttons = new HashMap<>();
        buttons.put("A", 0); buttons.put("B", 0); buttons.put("C", 0);
        int[] buttonTimes = {300, 60, 10};
        int time = input.nextInt();
        int count = 0;

        for (int i = 0; i < buttonTimes.length; i++) {
            count = time / buttonTimes[i];
            time = time % buttonTimes[i];

            if(buttonTimes[i] == 300)
                buttons.put("A", count);
            else if (buttonTimes[i] == 60)
                buttons.put("B", count);
            else if (buttonTimes[i] == 10)
                buttons.put("C", count);
        }

        if(time == 0) {
            System.out.print(buttons.get("A") + " ");
            System.out.print(buttons.get("B") + " ");
            System.out.print(buttons.get("C"));
        } else {
            System.out.println(-1);
        }
    }
}
