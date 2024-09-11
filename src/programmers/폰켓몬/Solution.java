package programmers.폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int k = nums.length / 2;

        HashSet<Integer> pokemon = new HashSet<>();
        for(int num : nums) {
            pokemon.add(num);
        }


        return Math.min(k, pokemon.size());
    }
}