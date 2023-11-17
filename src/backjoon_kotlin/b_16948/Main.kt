package backjoon_kotlin.b_16948

import java.util.*

private lateinit var visited: Array<BooleanArray>

val dy = arrayOf(-2, -2, 0, 0, 2, 2)
val dx = arrayOf(-1, 1, -2, 2, -1, 1)

var n = 0

var r1 = 0
var c1 = 0
var r2 = 0
var c2 = 0

data class Node(val y: Int, val x: Int, val moveCount: Int)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    readLine().split(" ").map { it.toInt() }.let {
        r1 = it[0]
        c1 = it[1]
        r2 = it[2]
        c2 = it[3]
    }

    visited = Array(n) { BooleanArray(n) }
    val queue = LinkedList<Node>() as Queue<Node>
    queue.offer(Node(r1, c1, 0))
    visited[r1][c1] = true

    while(queue.isNotEmpty()) {
        val target = queue.poll()
        for(i in 0 until 6) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if(nx !in 0 until n || ny !in 0 until n || visited[ny][nx]) continue
            if(ny == r2 && nx == c2) {
                println(target.moveCount + 1)
                return
            }

            visited[ny][nx] = true
            queue.offer(Node(ny, nx, target.moveCount + 1))
        }
    }

    println(-1)

}

