package backjoon_kotlin.b_1149

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { IntArray(3) }
    val dp = Array(n) { IntArray(3) }
    for(i in 0 until n) {
        val input = readLine()
        arr[i] = input.split(" ").map { it.toInt() }.toIntArray()
    }
    for(i in 0 until 3) {
        dp[0][i] = arr[0][i]
    }

    for(i in 1 until n) {
        dp[i][0] = dp[i - 1][1].coerceAtMost(dp[i - 1][2]) + arr[i][0]
        dp[i][1] = dp[i - 1][0].coerceAtMost(dp[i - 1][2]) + arr[i][1]
        dp[i][2] = dp[i - 1][0].coerceAtMost(dp[i - 1][1]) + arr[i][2]
    }

    println(dp[n - 1].min())
}