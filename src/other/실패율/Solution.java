package other.실패율;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] solution(int n, int[] stages) {
        int[] challengers = new int[n + 2];

        for (int stage : stages) {
            challengers[stage] += 1;
        }

        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        for(int i = 1; i <= n; i++) {
            if(challengers[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, challengers[i] / total);
                total -= challengers[i];
            }
        }

        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}
