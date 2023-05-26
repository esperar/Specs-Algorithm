package backjoon_kotlin.b_11727

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val dp = IntArray(n)
    dp[0] = 1
    dp[1] = 3

    for(i in 2 until n){
        dp[i] = dp[i - 1] + 2 * dp[i - 2]
    }

    println(dp[n - 1] % 10007)
}