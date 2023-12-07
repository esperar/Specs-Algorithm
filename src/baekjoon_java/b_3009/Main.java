package baekjoon_java.b_3009;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int[] coord1 = { sc.nextInt(), sc.nextInt() };
        int[] coord2 = { sc.nextInt(), sc.nextInt() };
        int[] coord3 = { sc.nextInt(), sc.nextInt() };

        sc.close();

        int x;
        int y;

        if(coord1[0] == coord2[0]) {
            x = coord3[0];
        } else if(coord1[0] == coord3[0]) {
            x = coord2[0];
        } else {
            x = coord1[0];
        }

        if(coord1[1] == coord2[1]) {
            y = coord3[1];
        } else if(coord1[1] == coord3[1]) {
            y = coord2[1];
        } else {
            y = coord1[1];
        }

        System.out.println(x + " " + y);

    }
}
