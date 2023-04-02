package backjoon_kotlin.b_7785

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val map = mutableMapOf<String, String>()

    repeat(N){
        val (name, log) = readLine().split(" ")
        map.put(name, log)
    }

    val keys = map.filterValues { it == "enter" }.keys.sortedDescending()

    for(i in keys){
        println(i)
    }
}

