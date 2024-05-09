package other.두_개의_수로_특정값_만들기;

import java.util.*;

public class Solution {

    public static boolean solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i : arr) {
            if(hashSet.contains(target - i)) {
                return true;
            }
            hashSet.add(i);
        }

        return false;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5}, 6);
    }
}
