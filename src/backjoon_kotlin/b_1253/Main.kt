package backjoon_kotlin.b_1253

import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.Buffer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    var count = 0
    for(k in 0 until N) {
        val find = arr[k]
        var i = 0
        var j = N - 1

        while (i < j) {
            if(arr[i] + arr[j] == find){

                if(i != k && j != k) {
                    count++
                    break
                } else if(i == k){
                    i++
                } else if(j == k){
                    j--
                }
            } else if(arr[i] + arr[j] < find){
                i++;
            } else {
                j--
            }
        }
    }

    println(count)
}