package backjoon_kotlin.b_11656

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine()
    val inputSize = input.length
    val suffix = mutableListOf<String>()
    for(i in input.indices) {
        val sb = StringBuilder()
        for(j in  i until inputSize) {
            sb.append(input[j])
        }
        suffix.add(sb.toString())
    }

    suffix.sort()

    for (s in suffix) {
        println(s)
    }
}