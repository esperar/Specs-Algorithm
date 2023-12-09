package study_note.stack;

import java.util.Stack;

public class StackImpl {

    // 메모리에 미리 올려놔요
    static int[] stack = new int[10];
    static int top = -1;

    public static void main(String[] args) {
        Stack<Integer> stack2 = new Stack<>();

    }

    static boolean isEmpty() {
        return top == -1;
    }

    static boolean isFull() {
        return top == stack.length -1;
    }

    static boolean push(int value) {
        // 가득 차 있는가
        if(isFull()) {
            return false;
        }

        stack[++top] = value;
        return true;
    }

    static int pop() {
        if(isEmpty()) {
            return -1; // 문제를 보고 공백상태에서 무엇을 반환해야하는지 판단하기
        }
        return stack[top--];
    }
}
