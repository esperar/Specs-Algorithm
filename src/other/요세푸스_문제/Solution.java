package other.요세푸스_문제;

import java.util.ArrayDeque;

public class Solution {
    public static int solution(int n, int k) {
        int answer = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            queue.addLast(i);
        }

        while(queue.size() > 1) {
            for(int i = 0; i < k - 1; i++) {
                queue.addLast(queue.pollFirst());
            }
            queue.pollFirst();
        }

        return queue.pollFirst();
    }
}
