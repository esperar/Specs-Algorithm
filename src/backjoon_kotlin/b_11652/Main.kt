package backjoon_kotlin.b_11652

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val input = mutableListOf<Long>()
    repeat(N){
        input.add(readLine().toLong())
    }
    input.sort()

    var count = 1
    var max = 1
    var result: Long = input[0]

    for(i in 1 until N){

        if(input[i] == input[i - 1])
            count++
        else
            count = 1

        if(max < count){
            max = count
            result = input[i]
        }
    }

    println(result)
}