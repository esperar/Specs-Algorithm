package programmers.신규_아이디_추천

import java.util.*

class Solution {
    fun solution(new_id: String): String {
        var answer: String = new_id
        answer = answer.lowercase(Locale.getDefault())
            .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
            .replace("[.]*[.]".toRegex(), ".")
            .removePrefix(".").removeSuffix(".")
            .let { it.ifEmpty { "a" } }
            .let {
                if (it.length >= 16) it.substring(0, 16).removeSuffix(".") else it
            }
            .let {
                if (it.length <= 2) {
                    val sb = StringBuilder(it)
                    while (sb.length != 3)
                        sb.append(it.last())
                    sb.toString()
                } else it
            }
        return answer
    }
}