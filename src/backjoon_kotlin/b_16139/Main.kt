package backjoon_kotlin.b_16139

fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()
    val input = readLine()
    val q = readLine().toInt()
    val sum = Array(input.length) { IntArray(26) }

    sum[0][input[0] - 'a'].inc()

    for(i in 1 until input.length) {
        val temp = input[i] - 'a'

        for(j in 0 until 26) {
            sum[i][j] = sum[i - 1][j]
        }
        sum[i][temp]++
    }

    for(i in 0 until q) {
        val (a, l, r) = readLine().split(" ")


        if(l.toInt() == 0) {
            sb.append("${sum[r.toInt()][a.first() - 'a']}\n")
        } else {
            sb.append("${sum[r.toInt()][a.first() - 'a'] - sum[l.toInt() - 1][a.first() - 'a']}\n")
        }
    }

    println(sb)
}