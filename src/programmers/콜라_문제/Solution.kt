package programmers.콜라_문제

class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var bottle = n

        while(bottle >= a) {
            val quotient = bottle / a
            val newBottle = quotient * b
            bottle -= a * quotient
            bottle += newBottle
            answer += newBottle
        }

        return answer
    }
}