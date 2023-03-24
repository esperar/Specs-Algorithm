package backjoon_kotlin.b_1436

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    var count = 0
    var num = 665

    while (count < n){
        num += 1
        if ("666" in num.toString())
            count += 1
    }

    println(num)
}