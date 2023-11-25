package backjoon_kotlin.b_20291

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = mutableMapOf<String, Int>()
    val sb = StringBuilder()

    for(i in 0 until n) {
        val extension = readLine().split(".")[1]
        map[extension] = map[extension]?.plus(1) ?: 1
    }

    val sortedMap = map.toList().sortedBy { it.first }.toMap()

    for ((key, value) in sortedMap) {
        sb.append("$key $value\n")
    }

    println(sb)
}