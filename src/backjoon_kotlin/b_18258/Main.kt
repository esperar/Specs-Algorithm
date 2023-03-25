package backjoon_kotlin.b_18258

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val queue: Queue<Int> = LinkedList()
    var last = 0
    val sb = StringBuilder()
    val n = readLine()!!.toInt()

    repeat(n) {
        val input = readLine()!!.split(" ")
        when (input[0]) {
            "push" -> {
                last = input[1].toInt()
                queue.add(last)
            }
            "pop" -> sb.appendLine(if (queue.isEmpty()) -1 else queue.poll())
            "size" -> sb.appendLine(queue.size)
            "empty" -> sb.appendLine(if (queue.isEmpty()) 1 else 0)
            "front" -> sb.appendLine(if (queue.isEmpty()) -1 else queue.peek())
            "back" -> sb.appendLine(if (queue.isEmpty()) -1 else last)
        }
    }
    print(sb)
}