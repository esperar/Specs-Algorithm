package backjoon_kotlin.b_8394

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val dp = LongArray(10000001)

    dp[1] = 1
    dp[2] = 2

    for(i in 3 ..n){
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10
    }

    println(dp[n])
}