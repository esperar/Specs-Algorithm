package b_1712;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            int count = 1;
            input--;
            while(input > 0) {
                input -= count * 6;
                count++;
            }
            System.out.println(count);
    }
}

