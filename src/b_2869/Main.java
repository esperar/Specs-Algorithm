package b_2869;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int up = input.nextInt();
        int down = input.nextInt();
        int length = input.nextInt();

        int day = (length - down) / (up - down);
        if((length - down) % (up - down) != 0){
            day++;
        }

        System.out.println(day);
    }
}

