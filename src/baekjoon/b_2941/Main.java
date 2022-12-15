package baekjoon.b_2941;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'c') {
                if (i < input.length() - 1) {
                    if (input.charAt(i + 1) == '=')
                        i++;

                    else if (input.charAt(i + 1) == '-')
                        i++;
                }
            }

            else if (input.charAt(i) == 'd') {
                if(i < input.length() - 1) {
                    if (input.charAt(i + 1) == 'z') {
                        if (input.charAt(i + 2) == '=') {
                            i += 2;
                        }
                    } else if (input.charAt(i + 1) == '-') {
                        i++;
                    }
                }
            }

            else if( input.charAt(i) == 'l') {
                if(i < input.length() - 1) {
                    if (input.charAt(i + 1) == 'j') {
                        i++;
                    }
                }
            }

            else if(input.charAt(i) =='n'){
                if(input.charAt(i + 1) == 'j') {
                    i++;
                }
            }

            else if(input.charAt(i) == 's') {
                if(input.charAt(i + 1) == '=') {
                    i++;
                }
            }

            else if(input.charAt(i) == 'z') {
                if(input.charAt(i+1) == '=') {
                    i++;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}