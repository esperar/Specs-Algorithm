package backjoon_kotlin.b_10813

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val ballPot = IntArray(n) { it + 1 }

    repeat(m){
        val(i, j) = readLine().split(" ").map { it.toInt() }
        ballPot[i - 1] = ballPot[j - 1].also { ballPot[j - 1] = ballPot[i - 1] }
    }

    for (ball in ballPot) {
        print("$ball ")
    }

}