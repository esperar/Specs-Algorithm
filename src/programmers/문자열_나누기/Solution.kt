package programmers.문자열_나누기

class Solution {
    fun solution(s: String): Int {
        var answer = 1
        var first = s[0]
        var firstCount = 1
        var differenceCount = 0

        for(i in 1 until s.length){

            if(firstCount == differenceCount) {
                answer += 1
                firstCount = 1
                differenceCount = 1
                first = s[i]
            }

            if(s[i] == first) {
                firstCount++
            } else {
                differenceCount++
            }
        }

        return answer
    }
}