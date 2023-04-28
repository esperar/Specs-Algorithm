package backjoon_kotlin.b_11651

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val input = List(readLine().toInt()) {
        readLine().split(" ")
            .let { Pair(it[0].toInt(), it[1].toInt()) }}
        .sortedWith( compareBy({ it.second } , { it.first }))

    for(i in input){
        sb.append(("${i.first} ${i.second}\n"))
    }

    println(sb.toString())
}