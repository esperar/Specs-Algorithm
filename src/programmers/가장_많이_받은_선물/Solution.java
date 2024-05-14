package programmers.가장_많이_받은_선물;

import java.util.*;

public class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 1. 관계에서 선물 . 더많은
        //
        // 2. if 같거나 없을때 (1) (2) 선물 지수 저장하기

        // 그러면 입력 받으면
        // 일단 A B가 B에게 줬다는 정보를 기록해야하는데.
        // HashMap으로 gift 정보의 key를 만들어서
        // 1.
        // 읽단 선물 현황 배열을 만들어야할 것 같습니다.
        // 일단 해쉬맵으로 이름 (인덱스)를 먼저. 저장합시다.
        HashMap<String, Integer> users = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            users.put(friends[i], i);
        }

        // 이차원 배열로 선물 현황의 배열을 저장합니다.
        // 선물 지수도 올려줍니다
        int[][] board = new int[friends.length][friends.length];
        for(int i = 0; i < board.length; i++) {
            board[i][i] = -1;
        }

        int[][] giftRecord = new int[friends.length][2];
        for(int i = 0; i < gifts.length; i++) {
            // 선물 현황 기록
            String[] record = gifts[i].split(" ");

            Integer from = users.get(record[0]);
            Integer to = users.get(record[1]);
            System.out.println(from +"이 " + to);

            board[from][to]++;

            // 선물 지수 기록
            giftRecord[from][0]++; // 준 선물 기록
            giftRecord[to][1]++; // 받은 선물 기록
        }

        int[] result = new int[friends.length];

        // 조건 검사
        for(int i = 0; i < board.length; i++) {
            for(int j = i; j < board.length; j++) {
                if(i != j) {

                    // 만약 i 보다 j가 받은 선물이 . 더많다면
                    if(board[i][j] > board[j][i]) {
                        // i 친구에게 ++
                        result[users.get(friends[i])]++;
                    } else if(board[i][j] < board[j][i]) {
                        result[users.get(friends[j])]++;
                    } else if(board[i][j] == board[j][i]){
                        // 지수 비교
                        int iRecord = giftRecord[users.get(friends[i])][0] - giftRecord[users.get(friends[i])][1];
                        int jRecord = giftRecord[users.get(friends[j])][0] - giftRecord[users.get(friends[j])][1];

                        if(iRecord > jRecord) {
                            result[users.get(friends[i])]++;
                        } else if(iRecord < jRecord){
                            result[users.get(friends[j])]++;
                        }
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i < result.length; i++) {
            if(max < result[i]) {
                max = result[i];
            }
        }


        return max;
    }
}