package other.배열_제어하기;

import java.util.*;

public class Main {

    static int[] solution(int[] arr) {
        int[] clone = arr.clone();
        Integer[] result = Arrays.stream(clone).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

}
