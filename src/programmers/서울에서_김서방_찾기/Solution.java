package programmers.서울에서_김서방_찾기;

class Solution {

    public String solution(String[] seoul) {
        String answer = "김서방은 " + find(seoul) +"에 있다";
        return answer;
    }

    public static int find(String[] seoul) {
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                return i;
            }
        }
        return -1;
    }
}
