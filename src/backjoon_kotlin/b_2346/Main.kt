package backjoon_kotlin.b_2346

import java.lang.StringBuilder
import kotlin.math.absoluteValue

data class Balloon(val number: Int, val paper: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val papers = readLine().split(" ").map { it.toInt() }
    val balloons = ArrayDeque((1 .. n).map {
        Balloon(it, papers[it - 1])
    })
    val sb = StringBuilder()

    while(true) {
        val balloon = balloons.removeFirst()
        sb.append("${balloon.number} ")

        if(balloons.isEmpty())
            break

        if(balloon.paper > 0) {
            for(i in 1 until balloon.paper) {
                balloons.addLast(balloons.removeFirst())
            }
        } else {
            for(i in 1.. balloon.paper.absoluteValue) {
                balloons.addFirst(balloons.removeLast())
            }
        }
    }

    println(sb.toString())
}

