package backjoon_kotlin.b_1969

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val input = mutableListOf<List<Char>>()
    var result = ""
    var count = 0

    repeat(n){
        input.add(readLine().toList())
    }


    for(i in 0 until m){
        val ATGC = IntArray(4) { 0 }
        for(j in 0 until n){
            when(input[j][i]){
                'A' -> ATGC[0]++
                'T' -> ATGC[1]++
                'G' -> ATGC[2]++
                else -> ATGC[3]++
            }
        }

        val max = ATGC.max()
        val maxIndex = ATGC.indexOf(max)

        result += when(maxIndex){
            0 -> 'A'
            1 -> 'T'
            2 -> 'G'
            else -> 'C'
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (result[j] != input[i][j]) {
                count++
            }
        }
    }

    println(result)
    println(count)
}