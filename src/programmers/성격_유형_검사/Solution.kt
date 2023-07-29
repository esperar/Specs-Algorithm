package programmers.성격_유형_검사

import java.lang.StringBuilder

class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val answer = StringBuilder()
        val map = mutableMapOf(
            'R' to 0, 'T' to 0,
            'C' to 0, 'F' to 0,
            'J' to 0, 'M' to 0,
            'A' to 0, 'N' to 0
        )
        val score = arrayOf(3, 2, 1, 0, 1, 2, 3)

        for(i in survey.indices) {
            if(choices[i] >= 5) {
                map[survey[i][1]] = map[survey[i][1]]!! + score[choices[i] - 1]
            } else if(choices[i] <= 3) {
                map[survey[i][0]] = map[survey[i][0]]!! + score[choices[i] - 1]
            }
        }

        answer.append(if(map['R']!! >= map['T']!!) "R" else "T")
        answer.append(if(map['C']!! >= map['F']!!) "C" else "F")
        answer.append(if(map['J']!! >= map['M']!!) "J" else "M")
        answer.append(if(map['A']!! >= map['N']!!) "A" else "N")


        return answer.toString()
    }
}