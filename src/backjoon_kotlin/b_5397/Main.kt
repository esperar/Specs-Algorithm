package backjoon_kotlin.b_5397

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    sc.nextLine()

    repeat(t) {
        val input = sc.nextLine()
        val leftDeque = ArrayDeque<Char>()
        val rightDeque = ArrayDeque<Char>()

        for (c in input) {
            when (c) {
                '-' -> if (leftDeque.isNotEmpty()) leftDeque.removeLast()
                '<' -> if (leftDeque.isNotEmpty()) rightDeque.addFirst(leftDeque.removeLast())
                '>' -> if (rightDeque.isNotEmpty()) leftDeque.addLast(rightDeque.removeFirst())
                else -> leftDeque.addLast(c)
            }
        }

        leftDeque.addAll(rightDeque)
        println(leftDeque.joinToString(""))
    }
}
