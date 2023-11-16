package backjoon_kotlin.b_17086

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private lateinit var graph: Array<IntArray>
private lateinit var distance: Array<IntArray>

val dx = arrayOf(0, 1, 0, -1, 1, 1, -1, -1)
val dy = arrayOf(1, 0, -1, 0, 1, -1, 1, -1)

var n = 0
var m = 0
var count = 0

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.let {
        n = it[0]
        m = it[1]
    }

    graph = Array(n) { IntArray(m) }
    distance = Array(n) { IntArray(m) }

    val queue = LinkedList<Node>() as Queue<Node>

    for(i in 0 until n) {
        val st = StringTokenizer(readLine(), " ")
        for(j in 0 until m) {
            val token = st.nextToken().toInt()
            graph[i][j] = token
            distance[i][j] = Integer.MAX_VALUE
            if(token == 1) {
                queue.offer(Node(i, j))
                distance[i][j] = 0
            }
        }
    }

    while(queue.isNotEmpty()) {
        val target = queue.poll()

        for(i in 0 until 8) {
            val di = target.x + dx[i]
            val dj = target.y + dy[i]

            if(di !in 0 until n || dj !in 0 until m) continue
            if(distance[di][dj] > distance[target.x][target.y] + 1) {
                distance[di][dj] = distance[target.x][target.y] + 1
                queue.add(Node(di, dj))
                count = count.coerceAtLeast(distance[di][dj])
            }
        }
    }

    println(count)
}
