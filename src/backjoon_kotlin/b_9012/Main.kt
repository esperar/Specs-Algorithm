package backjoon_kotlin.b_9012

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine()!!.toInt()

    repeat(T){
        val input = readLine()
        println(if(isVPS(input)) "YES" else "NO")
    }
}

fun isVPS(input: String): Boolean{
    val stack = Stack<Char>()

    for (data in input) {
        if (data == '(') {
            stack.push(data)
        } else if (data == ')') {
            if (stack.isEmpty()) {
                return false
            } else {
                stack.pop()
            }
        }
    }

    return stack.isEmpty()
}