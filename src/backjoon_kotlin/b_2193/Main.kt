package backjoon_kotlin.b_2193


fun main() = with(System.`in`.bufferedReader()){
    val n = readLine()!!.toInt()
    val dp = LongArray(n)
    dp[0] = 1
    dp[1] = 1

    for(i in 2 until n){
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    println(dp[n - 1])
}