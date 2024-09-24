package backjoon_kotlin.b_12865

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val arr = Array(n + 1){ Array(2){0} }
    val dp = Array(n + 1){ Array(k + 1){0} }

    for (i in 1 .. n) {
        val st2 = StringTokenizer(br.readLine())
        arr[i][0] = st2.nextToken().toInt()
        arr[i][1] = st2.nextToken().toInt()
    }

    for (i in 1 .. n) {
        for (j in 1 .. k) {
            val weight = arr[i][0]
            val value = arr[i][1]

            if(weight > j) {
                dp[i][j] = dp[i-1][j]
            } else {
                dp[i][j] = max(value + dp[i - 1][j - weight], dp[i - 1][j])
            }
        }
    }

    println(dp[n][k])
}