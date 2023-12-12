package programmers.타겟_넘버;

class Solution {

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public static  void dfs(int[] numbers, int target, int sum, int depth) {
        if(depth == numbers.length) {
            if(sum == target) answer++;
        } else {
            dfs(numbers, target, sum + numbers[depth], ++depth);
            dfs(numbers, target, sum - numbers[depth], ++depth);
        }
    }
}