package programmers.명예의전당;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {

        List<Integer> rank = new ArrayList<>();
        int[] answer = new int[score.length];

        for(int i = 0; i < score.length; i++) {
            if(i < k) {
                rank.add(score[i]);
                rank.sort(Collections.reverseOrder());
                answer[i]=rank.get(rank.size()-1);
            } else {
                rank.add(score[i]);
                rank.sort(Collections.reverseOrder());
                answer[i]=rank.get(k-1);
            }
        }

        return answer;
    }
}