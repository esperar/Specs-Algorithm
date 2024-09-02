package baekjoon_java.b_15815;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String input = sc.next();
        for(char c : input.toCharArray()) {
            if(c >= '0') {
                stack.push(c - '0');
            } else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(n1 + n2);
                        break;
                    case '-':
                        stack.push(n2 - n1);
                        break;
                    case '*':
                        stack.push(n1 * n2);
                        break;
                    case '/':
                        stack.push(n2 / n1);
                        break;
                }
            }
        }

        System.out.println(stack.pop());
    }
}
