package backjoon_kotlin.b_1389

import java.util.LinkedList
import java.util.Queue

var n = 0
var m = 0
private lateinit var edge: Array<ArrayList<Int>>
private lateinit var visited: BooleanArray

var min = Integer.MAX_VALUE
var minUser = 0

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    edge = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)

    for(i in 0 until m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        edge[a].add(b)
        edge[b].add(a)
    }

    for(i in 1 .. n) {
        var count = 0
        for(j in 1 .. n) {
            if(i == j) continue
            visited.fill(false)
            count += bfs(i, j)
        }
        if(min > count) {
            min = count
            minUser = i
        }
    }

    println(minUser)
}


fun bfs(start: Int, to: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(start, 0))
    while(queue.isNotEmpty()){
        val (cur, curCount) = queue.poll()
        if(cur == to) return curCount
        for(i in edge[cur].indices) {
            val next = edge[cur][i]
            if(visited[next]) continue
            queue.add(Pair(next, curCount + 1))
        }
    }
    return 0
}