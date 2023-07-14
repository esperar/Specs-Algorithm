package backjoon_kotlin.b_2579

import java.lang.Math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n + 1){ 0 }
    val dp = Array(n + 1) { 0 }

    for(i in 1 until arr.size) {
        arr[i] = readLine().toInt()
    }

    for(i in 1 until dp.size) {
        when(i){
            1 -> dp[1] = arr[1]
            2 -> dp[2] = arr[1] + arr[2]
            else -> {
                dp[i] = max((arr[i] + dp[i - 2]),(arr[i] + arr[i - 1] + dp[i - 3]))
            }
        }

    }

    println(dp[n])
}