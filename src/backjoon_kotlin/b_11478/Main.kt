package backjoon_kotlin.b_11478

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine()
    val stringSet = mutableSetOf<String>()

    for(i in input.indices){
        for(j in i + 1..input.length){
            stringSet.add(input.substring(i,j))
        }
    }

    println(stringSet.size)
}