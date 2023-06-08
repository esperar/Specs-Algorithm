package backjoon_kotlin.b_2644

import java.util.LinkedList
import java.util.Queue

lateinit var graph: Array<IntArray>
lateinit var visited: BooleanArray

var N = 0
var family1 = 0
var family2 = 0
var M = 0

var result = 0

fun main() = with(System.`in`.bufferedReader()){
    N = readLine().toInt()
    val input = readLine().split(" ").map { it.toInt() }
    family1 = input[0]
    family2 = input[1]
    M = readLine().toInt()

    graph = Array(N + 1) { IntArray(N + 1) }
    visited= BooleanArray(N + 1)

    for(i in 0 until M){
        val(n,m) = readLine().split(" ").map { it.toInt() }
        graph[n][m] = 1
        graph[m][n] = 1
    }

    bfs(family1)
}

fun bfs(start: Int){
    val queue: Queue<Int> = LinkedList()
    queue.offer(start)
    visited[start] = true

    while(queue.isNotEmpty()){
        for(i in 1 .. queue.size){
            val temp = queue.poll()
            if(family2 == temp)
                return println(result)

            for(j in 1..N){
                if(!visited[j] && graph[temp][j] == 1){
                    queue.offer(j)
                    visited[j] = true
                }
            }
        }
        result++
    }

    println(-1)
}

