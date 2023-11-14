package backjoon_kotlin.b_18352

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

private lateinit var graph: Array<ArrayList<Int>>
private lateinit var visited: IntArray

val sb = StringBuilder()

var n = 0
var m = 0
var k = 0
var x = 0

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.let {
        n = it[0]
        m = it[1]
        k = it[2]
        x = it[3]
    }

    graph = Array(n + 1) { ArrayList() }
    visited = IntArray(n + 1) { -1 }


    for(i in 0 until m) {
        val(a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
    }

    bfs(x)

    for(i in 1 .. n) {
        if(visited[i] == k) sb.append("$i\n")
    }

    println(sb.ifEmpty { -1 })
}

fun bfs(v: Int) {
    val queue = LinkedList<Int>() as Queue<Int>
    visited[v] = 0
    queue.offer(v)

    while(queue.isNotEmpty()) {
        val target = queue.poll()
        for(next in graph[target]) {
            if(visited[next] == -1) {
                queue.offer(next)
                visited[next] = visited[target] + 1
            }
        }
    }
}