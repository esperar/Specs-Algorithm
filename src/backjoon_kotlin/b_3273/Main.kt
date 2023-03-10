package backjoon_kotlin.b_3273

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val target = readLine().toInt()

    arr.sort()
    var i = 0
    var j = n - 1
    var count = 0

    while (i < j) {
        if(arr[i] + arr[j] > target) {
            j--
        } else if(arr[i] + arr[j] < target){
            i++
        } else {
            count++;
            i++
            j--
        }
    }

    println(count)
}