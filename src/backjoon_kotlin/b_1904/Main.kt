package backjoon_kotlin.b_1904

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()

    val dp = Array(1000001) { 0 }
    dp[1] = 1
    dp[2] = 2

    for(i in 3 .. n){
        dp[i] = (dp[i - 1] + dp[i - 2]) % 15746
    }

    println(dp[n])

}