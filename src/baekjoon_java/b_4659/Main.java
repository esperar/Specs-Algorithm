package baekjoon_java.b_4659;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        with: while(true) {
            input = sc.next();
            if(input.equals("end")) break;
            if(!containsVowel(input)) {
                append(input, false);
                continue;
            }

            if(input.length() >= 3) {
                for(int i = 0; i < input.length() - 2; i++) {
                    if(isVowel(input.charAt(i)) && isVowel(input.charAt(i + 1)) && isVowel(input.charAt(i + 2))) {
                        append(input, false);
                        continue with;
                    } else if(!isVowel(input.charAt(i)) && !isVowel(input.charAt(i + 1)) && !isVowel(input.charAt(i + 2))) {
                        append(input, false);
                        continue with;
                    }
                }
            }

            if(input.length() >= 2) {
                for(int i = 0; i < input.length() - 1; i++) {
                    if(input.charAt(i) != 'e' && input.charAt(i) != 'o') {
                        if(input.charAt(i) == input.charAt(i + 1)) {
                           append(input, false);
                            continue with;
                        }
                    }
                }
            }

            append(input, true);
        }

        System.out.println(sb.toString());
    }

    static void append(String input, boolean isAcceptable) {
        if(isAcceptable) {
            sb.append("<")
                    .append(input)
                    .append(">")
                    .append(" is acceptable.\n");
        } else {
            sb.append("<")
                    .append(input)
                    .append(">")
                    .append(" is not acceptable.\n");
        }
    }

    static boolean isVowel(char c) {
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e' ,'i', 'o', 'u'));
        return vowels.contains(c);
    }

    static boolean containsVowel(String input) {
        String[] vowels = {"a", "e", "i", "o", "u"};
        for(String vowel : vowels) {
            boolean isContains = input.contains(vowel);
            if(isContains) {
                return true;
            }
        }
        return false;
    }
}
