package programmers.가장_가까운_글자;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] solution = solution(input);
        System.out.println(solution.toString());
    }

    public static int[] solution(String s) {

        char[] words = new char[s.length()];
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            words[i] = s.charAt(i);
        }

        for(int i = 0; i < words.length; i++) {

            if(i == 0) {
                answer[i] = -1;
            }

            else {
                for (int j = i - 1; j >= 0; j--) {
                    if (words[i] == words[j]) {
                        answer[i] = i - j;
                        break;
                    }
                    else {
                        answer[i] = -1;
                    }
                }
            }
        }


        return answer;
    }
}
