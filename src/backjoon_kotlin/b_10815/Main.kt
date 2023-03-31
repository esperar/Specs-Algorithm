package backjoon_kotlin.b_10815

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val card = readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()

    for(i in card){
        map[i] = 1
    }
    val M = readLine().toInt()
    val card2 = readLine().split(" ").map { it.toInt() }

    for (i in card2){
        print(if(map.get(i) == 1) "1 " else "0 ")
    }
}

