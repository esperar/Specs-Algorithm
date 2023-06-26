package backjoon_kotlin.b_10845

import java.util.*

val queue: Queue<Int> = LinkedList()

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    for(i in 0 until n){
        val input = readLine()
        when(input){
            "pop" -> println(if(queue.isNotEmpty()) queue.poll() else -1)
            "size" -> println(queue.size)
            "empty" -> println(if(queue.isEmpty()) 1 else 0)
            "front" -> println(if(queue.isNotEmpty()) queue.first() else -1)
            "back" -> println(if(queue.isNotEmpty()) queue.last() else -1)
            else -> {
                val pushInput = input.split(" ")
                queue.offer(pushInput[1].toInt())
            }
        }
    }
}
