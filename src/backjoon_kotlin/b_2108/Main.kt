package backjoon_kotlin.b_2108

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val arr = mutableListOf<Int>()

    for(i in 0 until N){
        arr.add(readLine().toInt())
    }


    arr.sort()
    // -1 -1 -2 -2 -3
    val average = (arr.sum() / N.toDouble()).roundToInt()
    val median = if(N % 2 == 0) (arr[N / 2 - 1] + arr[N / 2]) / 2 else arr[N / 2]
    val mode = getMode(arr)
    val range = arr[N - 1] - arr[0]

    println(average)
    println(median)
    println(mode)
    println(range)
}

fun getMode(arr: List<Int>): Int {
    val freqMap = arr.groupingBy { it }.eachCount()
    val maxValue = freqMap.maxOf { it.value }
    val maxFreqMap = freqMap.filter { it.value == maxValue }
    val mapKeys = maxFreqMap.keys.sorted()

    return if (mapKeys.size == 1) {
        mapKeys.first()
    } else {
        mapKeys[1]
    }
}
