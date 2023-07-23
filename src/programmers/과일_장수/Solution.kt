package programmers.과일_장수

class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer = 0

        val sortedScore = score.sortedDescending()

        val boxCount = sortedScore.size / m

        for (i in 0 until boxCount) {
            val box = sortedScore.slice(i * m until (i + 1) * m)
            val minScore = box.last()
            answer += minScore * m
        }

        return answer
    }
}