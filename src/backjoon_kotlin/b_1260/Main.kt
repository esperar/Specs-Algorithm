package backjoon_kotlin.b_1260

import java.io.*
import java.util.*

var N: Int = 0
var M: Int = 0
var V: Int = 0
var graph: Array<IntArray> = arrayOf()
var visited: BooleanArray = booleanArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nmv = readLine().split(" ")
    N = nmv[0].toInt()
    M = nmv[1].toInt()
    V = nmv[2].toInt()

    graph = Array(N+1) { IntArray( N+1 ) }
    visited = BooleanArray(N+1)

    for ( i in 0 until M ) {
        val net = readLine()!!.split(" ")
        val a = (net[0] + "").toInt()
        val b = (net[1] + "").toInt()
        graph[a][b] = 1
        graph[b][a] = 1
    }

    visited.fill(false)
    dfs(V)

    println()
    visited.fill(false)

    bfs(V)
}

fun dfs(v: Int) {
    visited[v] = true
    print("$v ")
    for (i in 1 until N + 1) {
        if (graph[v][i] == 1 && !visited[i])
            dfs(i)
    }
}

fun bfs(v: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(v)
    visited[v] = true
    print("$v ")
    while (!queue.isEmpty()) {
        val d = queue.poll()
        for (i in 0 until N + 1) {
            if (graph[d][i] == 1 && !visited[i]){
                queue.add(i)
                visited[i] = true
                print("$i ")
            }
        }
    }
}