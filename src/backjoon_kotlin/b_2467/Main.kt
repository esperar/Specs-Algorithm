package backjoon_kotlin.b_2467

import kotlin.math.absoluteValue

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val input = readLine().split(" ").map { it.toInt() }
    var minDiff = Integer.MAX_VALUE
    var minL = 0
    var minR = input.size - 1
    var l = 0
    var r = input.size - 1

    while(l < r){
        val temp = input[l] + input[r]
        if(temp.absoluteValue < minDiff){
            minDiff = temp.absoluteValue
            minL = l
            minR = r
        }

        if(temp > 0) r--
        else if(temp < 0) l++
        else break
    }

    println("${input[minL]} ${input[minR]}")

}