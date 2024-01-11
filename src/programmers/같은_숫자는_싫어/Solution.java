package programmers.같은_숫자는_싫어;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if(stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        return new ArrayList<>(stack).stream().mapToInt(Integer::intValue).toArray();
    }

}