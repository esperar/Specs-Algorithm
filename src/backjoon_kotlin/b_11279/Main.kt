package backjoon_kotlin.b_11279

import java.lang.StringBuilder
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val heap = PriorityQueue<Int>(Comparator.reverseOrder())
    val sb = StringBuilder()

    for(i in 0 until n){
        val x = readLine().toInt()

        if(x == 0){
            if(heap.isEmpty()){
                sb.append("0\n")
            } else {
                sb.append("${heap.poll()}\n")
            }
        } else {
            heap.offer(x)
        }
    }

    println(sb)
}