package baekjoon_java.b_12789;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        int need = 1;
        while(!queue.isEmpty()) {
            if(queue.peek() == need) {
                queue.poll();
                need++;
            } else if(!stack.isEmpty() && stack.peek() == need) {
                stack.pop();
                need++;
            } else {
                stack.push(queue.poll());
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peek() == need) {
                stack.pop();
                need++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}
