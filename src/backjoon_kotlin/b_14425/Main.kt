package backjoon_kotlin.b_14425

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val strings = mutableMapOf<String, Int>()
    val (N, M) = readLine().split(" ").map { it.toInt() }
    var count = 0
    repeat(N){
        strings.put(readLine(), 1)
    }

    repeat(M){
        if(strings.containsKey(readLine()))
            count++
    }

    println(count)
}