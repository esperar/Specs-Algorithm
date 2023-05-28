package backjoon_kotlin.b_9657

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val dp = IntArray(1001)

    dp[1] = 1
    dp[2] = 0
    dp[3] = 1
    dp[4] = 1
    dp[5] = 1

    for(i in 6 .. n){
        dp[i] = 0
        if(dp[i - 1] == 0)
            dp[i] = 1
        if(dp[i - 3] == 0)
            dp[i] = 1
        if(dp[i - 4] == 0)
            dp[i] = 1
    }

    println(if(dp[n] == 1) "SK" else "CY")
}