package other.방문_길이;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void init() {
        location.put('U', new int[]{0, -1});
        location.put('D', new int[]{0, 1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        char[] order = sc.next().toCharArray();
        HashSet<String> answer = new HashSet<>();
        int x = 5, y = 5;
        for(int i = 0; i < order.length; i++) {
            int[] offset = location.get(order[i]);

            int nx = x + offset[0];
            int ny = y + offset[1];

            if(nx < 11 && nx >= 0 && ny < 11 && ny >= 0) {
                answer.add(x + " " + y + " " + nx + " " + ny);
                answer.add(nx + " " + ny + " " + x + " " + y);
                x = nx;
                y = ny;
            }

            System.out.println(answer.size() / 2);
        }

    }
}
