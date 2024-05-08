package other.두_개_뽑아서_더하기;

import java.util.HashSet;

public class Main {
    static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
