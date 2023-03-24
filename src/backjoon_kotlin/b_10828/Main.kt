package backjoon_kotlin.b_10828

import java.util.*

fun main() {
    val stack = Stack<Int>()
    val n = readLine()!!.toInt()
    repeat(n) {
        val command = readLine()!!.split(" ")
        when (command[0]) {
            "push" -> stack.push(command[1].toInt())
            "pop" -> println(if (stack.isEmpty()) -1 else stack.pop())
            "size" -> println(stack.size)
            "empty" -> println(if (stack.isEmpty()) 1 else 0)
            "top" -> println(if (stack.isEmpty()) -1 else stack.peek())
        }
    }
}