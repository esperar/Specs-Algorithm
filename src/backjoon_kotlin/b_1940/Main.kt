package backjoon_kotlin.b_1940

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val M = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    arr.sort()
    var count = 0
    var i = 0
    var j = N - 1

    while (i < j) {
        if(arr[i] + arr[j] > M) {
            j--
        } else if(arr[i] + arr[j] < M){
            i++
        } else {
            count++
            i++
            j--
        }
    }
    println(count)
}