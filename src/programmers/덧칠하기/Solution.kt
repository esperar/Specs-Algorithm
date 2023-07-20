package programmers.덧칠하기

class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer = 1
        var start = section[0]
        var end = section[0] + (m - 1)

        for(i in section) {
            if(i in start..end) {
                continue
            } else {
                start = i
                end = i + (m - 1)
                answer++
            }
        }

        return answer
    }
}