package other.다단계_칫솔_판매;

import java.util.*;

class Solutions {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        HashMap<String, String> parent = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> total = new HashMap<>();

        for(int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int money = amount[i] * 100;
            while(money > 0 && !s.equals("-")) {
                total.put(s, total.getOrDefault(s, 0) + money - (money / 10));
                s = parent.get(s);
                money /= 10;
            }
        }

        int[] answer = new int[enroll.length];

        for(int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}