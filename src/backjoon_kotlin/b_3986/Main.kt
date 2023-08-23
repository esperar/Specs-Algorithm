package backjoon_kotlin.b_3986

import java.util.Stack


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var result = 0
    repeat(n) {
        val input = readLine()
        val stack = Stack<Char>()

        for (c in input) {
            if(stack.isNotEmpty() && stack.peek() == c) stack.pop()
            else stack.add(c)
        }

        if(stack.isEmpty()) result++
    }

    println(result)
}