package baekjoon.b_10757;

import java.math.BigInteger;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BigInteger A = new BigInteger(in.next());
        BigInteger B = new BigInteger(in.next());

        A = A.add(B);

        System.out.println(A.toString());
    }
}
