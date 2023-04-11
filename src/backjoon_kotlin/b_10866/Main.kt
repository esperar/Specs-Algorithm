package backjoon_kotlin.b_10866

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()
    repeat(n){
        val input = readLine().split(" ")
        when(input[0]){
            "push_back" -> deque.addLast(input[1].toInt())
            "push_front" -> deque.addFirst(input[1].toInt())
            "pop_back" -> sb.appendln((if(deque.isEmpty()) -1 else deque.removeLast()))
            "pop_front" -> sb.appendln(if(deque.isEmpty()) -1 else deque.removeFirst())
            "size" -> sb.appendln(deque.size)
            "empty" -> sb.appendln(if(deque.isEmpty()) 1 else 0)
            "front" -> sb.appendln(if(deque.isEmpty()) -1 else deque.first())
            "back" -> sb.appendln(if(deque.isEmpty()) -1 else deque.last())
        }
    }
    println(sb)
}