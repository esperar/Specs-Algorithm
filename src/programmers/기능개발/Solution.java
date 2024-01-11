package programmers.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> task = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) {
                task.offer((100 - progresses[i]) / speeds[i]);
            } else {
                task.offer((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        int currentTask = task.poll();
        int count = 1;

        while(!task.isEmpty()) {
            if(currentTask >= task.peek()) {
                count++;
                task.poll();
            } else {
                answer.add(count);
                count = 1;
                currentTask = task.poll();
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}