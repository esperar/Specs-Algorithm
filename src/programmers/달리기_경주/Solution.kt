package programmers.달리기_경주

class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val indexes = HashMap<String, Int>()

        for (i in players.indices) {
            indexes[players[i]] = i
        }

        for (p in callings) {
            val index = indexes[p]
            if (index != null && index > 0) {
                val temp = players[index]
                players[index] = players[index - 1]
                players[index - 1] = temp
                indexes[players[index]] = index
                indexes[players[index - 1]] = index - 1
            }
        }

        return players
    }
}