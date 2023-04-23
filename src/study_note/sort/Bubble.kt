package study_note.sort

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine().split(" ").map { it.toInt() }.toMutableList()

    for(i in input.indices){
        var isSwap = false
        for(j in 0 until input.size - 1){
            if(input[j] > input[j + 1]){
                val temp = input[j]
                input[j] = input[j + 1]
                input[j + 1] = temp
                isSwap = true
            }
        }
        if(!isSwap) break
    }

    println(input.toString())

}