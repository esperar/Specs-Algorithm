package backjoon_kotlin.b_1021

import java.util.*

fun main() = with(System.`in`.bufferedReader()){

    val (n, m) = readLine().split(" ").map { it.toInt() }

    val queue = LinkedList<Int>()

    val choice = readLine().split(" ").map { it.toInt() }.toIntArray()

    for(i in 1 .. n)
        queue.add(i)

    var result = 0
    var count = 0

    while(count != m){
        if(queue.first() == choice[count]){
            queue.poll()
        } else {
            for(i in 1 until queue.size){
                if(queue[queue.size - i] == choice[count]){
                    while(queue[0] != choice[count]){
                        queue.add(0, queue.last)
                        queue.removeLast()
                        result++
                    }
                    queue.poll()
                    break
                } else if(queue[i] == choice[count]){
                    while(queue[0] != choice[count]){
                        queue.add(queue.first)
                        queue.removeFirst()
                        result++
                    }
                    queue.poll()
                    break
                }
            }
        }
        count++
    }
    println(result)
}