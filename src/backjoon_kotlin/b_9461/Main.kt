package backjoon_kotlin.b_9461


fun main() = with(System.`in`.bufferedReader()){
    val t = readLine()!!.toInt()
    val sb = StringBuilder()
    repeat(t){
        val dp = LongArray(100) { if (it < 3) 1 else 0 }
        val n = readLine()!!.toInt()
        for(i in 3 until 100){
            dp[i] = dp[i - 2] + dp[i - 3]
        }
        sb.append("${dp[n - 1]}\n")
    }
    println(sb)
}