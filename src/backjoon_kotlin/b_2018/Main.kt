package backjoon_kotlin.b_2018

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N: Int = readLine().toInt()
    var startIdx = 1
    var endIdx = 1
    var count = 1
    var sum = 1

    while (endIdx != N) {
        if(sum == N) {
            count++
            endIdx++
            sum += endIdx
        } else if(sum > N) {
            sum -= startIdx
            startIdx++
        } else {
            endIdx++
            sum += endIdx
        }
    }

    println(count)
}