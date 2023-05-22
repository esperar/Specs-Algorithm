package backjoon_kotlin.b_1463

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val list = MutableList(n + 1) { i -> i }

    list[0] = 0
    list[1] = 0

    for(i in 2 until list.size){
        list[i] = list[i - 1] + 1
        if(i % 2 == 0) list[i] = min(list[i], list[i / 2] + 1)
        if(i % 3 == 0) list[i] = min(list[i], list[i / 3] + 1)
    }

    println(list[n])
}