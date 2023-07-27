package programmers.크기가_작은_부분_문자열

import java.lang.StringBuilder

class Solution {

    fun solution(t: String, p: String): Int {
        var answer = 0
        val numbers = mutableListOf<String>()

        for(i in 0 until t.length - p.length) {
            val sb = StringBuilder()
            for(j in i until i + p.length) {
                sb.append("${t[j]}")
            }
            numbers.add(sb.toString())
        }

        answer = numbers.filter {
            it.toLong() <= p.toLong()
        }.size

        return answer
    }

}





