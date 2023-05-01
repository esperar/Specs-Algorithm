package backjoon_kotlin.b_10810

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val pot = IntArray(N)
    repeat(M){
        val (i,j,k) = readLine().split(" ").map { it.toInt() }

        for(potNumber in i..j){
            pot[potNumber - 1] = k
        }
    }

    for (num in pot) {
        print("$num ")
    }
}