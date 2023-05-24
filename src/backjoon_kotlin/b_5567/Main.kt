package backjoon_kotlin.b_5567

import java.util.*

var count = 0
var n: Int = 0
var m: Int = 0
var arr = Array(n + 1) { IntArray(n + 1) }
var visited =  Array(0){0}

fun main() = with(System.`in`.bufferedReader()){
    n = readLine()!!.toInt()
    m = readLine()!!.toInt()

    arr = Array(n+1) { IntArray(n + 1) { 0 } }
    visited = Array(n+1) {0}

    for(i in 0 until m){
        val (a,b) = readLine().split(" ").map { it.toInt() }
        arr[a][b] = 1
        arr[b][a] = 1
    }
    bfs(1)
    println(count)
}

fun bfs(start: Int){
    val queue: Queue<Int> = LinkedList()
    queue.offer(start)
    var level = 0
    visited[start] = 1
    while(queue.isNotEmpty()){
        for(i in 0 until queue.size){
            val head = queue.poll()
            for(j in 1..n){
                if(arr[head][j] == 1 && visited[j] == 0){
                    queue.offer(j)
                    count++
                    visited[j] = 1
                }
            }
        }
        level++
        if(level == 2) break
    }

}



