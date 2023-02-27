package backjoon_kotlin.b_1715

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.InputMismatchException
import java.util.PriorityQueue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val queue = PriorityQueue<Int>()
    var result = 0

    repeat(N) {
        queue.add(readLine().toInt())
    }

    while (queue.isNotEmpty()){
        val poll = queue.poll()
        if(queue.isNotEmpty()){
            val sum = poll + queue.poll()
            result += sum
            queue.add(sum)
        }
    }

    println(result)
}