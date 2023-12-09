package backjoon_kotlin.b_2164

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.Deque


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val queue: Deque<Int> = ArrayDeque()
    val N = readLine().toInt()

    for(i in 1..N){
       queue.add(i)
    }

    while (queue.size > 1){
        queue.pollFirst()
        queue.offerLast(queue.pollFirst())
    }

    println(queue.poll())
}
