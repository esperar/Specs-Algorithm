package programmers.개인정보_수집_유효기간

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()

        val todayTotal = totalDay(today)
        val map = hashMapOf<String, Int>()

        for (i in terms.indices) {
            val token = terms[i].split(" ")
            map[token[0]] = token[1].toInt()
        }

        for (i in privacies.indices) {
            val token = privacies[i].split(" ")

            val date = token[0]
            val type = token[1]

            val dateTotal = totalDay(date)
            val month = map[type] ?: 0
            val changedDay = month * 28

            if (todayTotal >= (dateTotal + changedDay)) {
                answer.add(i + 1)
            }
        }

        return answer.toIntArray()
    }

    private fun totalDay(todayTotal: String): Int {
        var sum = 0
        val token = todayTotal.split(".")
        val y = token[0]
        val m = token[1]
        val d = token[2]

        sum += y.toInt() * 12 * 28
        sum += (m.toInt() - 1) * 28
        sum += d.toInt()

        return sum
    }
}