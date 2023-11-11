package backjoon_kotlin.b_26215

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val snows = PriorityQueue<Int>(reverseOrder())
    var minute = 0
    StringTokenizer(readLine()).run {
        while(hasMoreTokens()) {
            val token = nextToken().toInt()
            if(token > 1440) {
                println(-1)
                return@with
            }
            snows.add(token)
        }
    }

    while(snows.size > 1) {
        val max = snows.poll()!!
        val secondMax = snows.poll() ?: 0
        snows.add(max - secondMax)
        minute += secondMax
    }
    minute += snows.poll() ?: 0
    println(if (minute > 1440) -1 else minute)

}