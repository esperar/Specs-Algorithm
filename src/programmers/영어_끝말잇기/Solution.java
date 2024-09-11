package programmers.영어_끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        char prevWord = words[0].charAt(0);

        for(int i = 0; i < words.length; i++) {
            if(wordSet.contains(words[i]) || words[i].charAt(0) != prevWord) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            wordSet.add(words[i]);
            prevWord = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0,0};
    }
}