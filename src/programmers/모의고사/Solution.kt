package programmers.모의고사

import java.util.*

class Solution {
    fun solution(answers: IntArray): IntArray {
        val result = mutableListOf<Int>()
        val player1 = intArrayOf(1, 2, 3, 4, 5)
        val player2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val player3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val scores = arrayListOf(0 ,0, 0)

        for ((idx, answer) in answers.withIndex()){
            if (answer == player1[idx % 5]){
                scores[0] += 1
            }
            if (answer == player2[idx % 8]){
                scores[1] += 1
            }
            if (answer == player3[idx % 10]){
                scores[2] += 1
            }
        }

        val max = Collections.max(scores)
        for ((idx, score) in scores.withIndex()){
            if (score == max){
                result.add(idx + 1)
            }
        }
        return result.toIntArray()
    }
}
