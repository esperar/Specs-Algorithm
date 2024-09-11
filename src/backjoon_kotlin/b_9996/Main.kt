package backjoon_kotlin.b_9996

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pattern = readLine().split("*")
    val start = pattern[0]
    val end = pattern[1]
    val sb = StringBuilder()

    for(i in 0 until n) {
        val input = readLine()
        if(input.length < start.length + end.length) {
            sb.append("NE").append("\n")
            continue
        }

        if(isMatched(input, start, end)) {
            sb.append("DA").append("\n")
        } else {
            sb.append("NE").append("\n")
        }
    }

    println(sb.toString())
}

private fun isMatched(text: String, start: String, end: String): Boolean {
    val front = text.substring(0, start.length)
    val back = text.substring(text.length - end.length, text.length)
    return front == start && back == end
}