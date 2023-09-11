package backjoon_kotlin.b_24511

import java.lang.StringBuilder


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    val queueOrStack = readLine().split(" ").map { it.toInt() }
    val deque = ArrayDeque<Int>()
    val values = readLine().split(" ").map { it.toInt() }

    for(i in values.indices) {
        if(queueOrStack[i] == 0) {
            deque.addLast(values[i])
        }
    }

    val c = readLine().toInt()
    val input = readLine().split(" ").map { it.toInt() }

    for(i in 0 until c) {
        deque.addFirst(input[i])
        sb.append("${deque.removeLast()} ")
    }

    print(sb.toString())
}