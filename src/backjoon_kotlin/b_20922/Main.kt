package backjoon_kotlin.b_20922

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val numbers = readLine().split(" ").map { it.toInt() }

    var left = 0
    var right = 0
    var max = 0
    var length = 0
    val checked = Array(101010) { LinkedList<Int>() }

    while(right != n) {
        if(checked[numbers[right]].size < k) {
            checked[numbers[right]].add(right)
            length++
            right++
        } else {
            val new = checked[numbers[right]].poll() + 1
            if(new > left) {
                length -= (new - left)
                left = new
            }
        }
        max = maxOf(max, length)
    }

    println(max)
}