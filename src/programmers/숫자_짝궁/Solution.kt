package programmers.숫자_짝궁

import java.lang.Integer.min
import java.lang.StringBuilder

class Solution {
    fun solution(X: String, Y: String): String {
        var answer = StringBuilder()
        val jjak = mutableSetOf<Int>()
        val result = mutableListOf<Int>()

        val xCount = IntArray(10)
        val yCount = IntArray(10)

        for(i in X){
            xCount[i.digitToInt()]++
        }

        for(j in Y){
            yCount[j.digitToInt()]++
        }

        for(i in X){
            if(Y.contains(i)){
                jjak.add(i.digitToInt())
            }
        }

        if(jjak.isNotEmpty()){

            if(jjak.first() == 0)
                answer.append("0")

            else {
                for (i in jjak.sortedDescending()) {
                    for (j in 0 until min(xCount[i], yCount[i])) {
                        result.add(i)
                    }
                }

                for (i in result) {
                    answer.append(i)
                }
            }

        } else {
            answer.append("-1")
        }

        return answer.toString()
    }
}