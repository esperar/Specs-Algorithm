package programmers.대충_만든_자판

class Solution {

    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val keyCountMap = mutableMapOf<Char, Int>()

        for (key in keymap) {
            for (i in key.indices) {
                val char = key[i]
                val count = i + 1
                keyCountMap[char] = keyCountMap[char]?.let { minOf(it, count) } ?: count
            }
        }

        val answer = mutableListOf<Int>()

        for (target in targets) {
            var count = 0
            for (char in target) {
                val keyPressCount = keyCountMap[char]
                if (keyPressCount == null) {
                    count = -1
                    break
                } else {
                    count += keyPressCount
                }
            }
            answer.add(count)
        }

        return answer.toIntArray()
    }
}