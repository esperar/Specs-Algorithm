package backjoon_kotlin.b_11726

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val dp = IntArray(1000) { 0 }
    dp[0] = 1
    dp[1] = 2

    for(i in 2 until n){
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    }

    println(dp[n - 1])
}