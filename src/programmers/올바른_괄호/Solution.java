package programmers.올바른_괄호;

import java.util.Stack;

class Solution {

    static Stack<Character> stack = new Stack<>();
    static boolean answer = true;


    boolean solution(String s) {

        if(s.charAt(0) == ')') {
            return false;
        }

        stack.push(s.charAt(0));

        validate(s);

        return answer;
    }

    void validate(String s) {

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')' && !stack.isEmpty()) {
                Character popData = stack.pop();
                if(popData != '(') {
                    answer = false;
                    return;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        answer = stack.isEmpty();
    }
}