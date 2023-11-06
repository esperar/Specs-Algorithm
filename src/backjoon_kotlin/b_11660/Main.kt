package backjoon_kotlin.b_11660

import java.lang.StringBuilder
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val numbers = Array(n + 1) { IntArray(n + 1) { 0 } }
    val sb = StringBuilder()

    for(i in 1 .. n) {
        val st = StringTokenizer(readLine())
        for(j in 1 .. n) {
            numbers[i][j] = st.nextToken().toInt()
        }
    }

    val sumNumbers = Array(n + 1) { IntArray(n + 1) { 0 } }

    for(i in 1 .. n) {
        for(j in 1 .. n) {
            sumNumbers[i][j] = sumNumbers[i][j - 1] + sumNumbers[i - 1][j] - sumNumbers[i - 1][j - 1] + numbers[i][j]
        }
    }

    for(i in 0 until m) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        val result = sumNumbers[x2][y2] - sumNumbers[x1 - 1][y2] - sumNumbers[x2][y1 - 1] + sumNumbers[x1 - 1][y1 - 1]
        sb.append("$result\n")
    }

    println(sb)
}