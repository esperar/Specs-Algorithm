package backjoon_kotlin.b_3187

import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<CharArray>
private lateinit var visited: Array<BooleanArray>

val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)

var n = 0
var m = 0

data class SheepAndWolfCount(var sheep: Int, var wolf: Int)
data class Node(val x: Int, val y: Int)

private val sheepAndWolfCase = ArrayList<SheepAndWolfCount>()

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.let {
        n = it[0]
        m = it[1]
    }

    graph = Array(n) { CharArray(m) }
    visited = Array(n) { BooleanArray(m) }

    for(i in 0 until n) {
        graph[i] = readLine().toCharArray()
    }

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(graph[i][j] != '#' && !visited[i][j])
                bfs(i, j)
        }
    }

    var wolf = 0
    var sheep = 0
    for(sheepAndWolf in sheepAndWolfCase) {
        if(sheepAndWolf.wolf < sheepAndWolf.sheep) {
            sheep += sheepAndWolf.sheep
        } else {
            wolf += sheepAndWolf.wolf
        }
    }

    println("$sheep $wolf")

}

fun bfs(x: Int, y: Int) {
    var wolfCount = 0
    var sheepCount = 0

    val queue = LinkedList<Node>() as Queue<Node>
    visited[x][y] = true
    queue.offer(Node(x, y))

    while(queue.isNotEmpty()) {
        val target = queue.poll()

        if(graph[target.x][target.y] == 'v') wolfCount++
        else if (graph[target.x][target.y] == 'k') sheepCount++

        for(i in 0 until 4) {
            val di = target.x + dx[i]
            val dj = target.y + dy[i]
            if(di !in 0 until n || dj !in 0 until m || graph[di][dj] == '#' || visited[di][dj]) continue
            visited[di][dj] = true
            queue.offer(Node(di, dj))
        }
    }

    sheepAndWolfCase.add(SheepAndWolfCount(wolf = wolfCount, sheep = sheepCount))
}