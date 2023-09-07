package backjoon_kotlin.b_7576

import java.util.*

val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)


private lateinit var box: Array<IntArray>

val queue: Queue<Node> = LinkedList()

var n = 0
var m = 0
var unripeCount = 0

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[1]
    m = input[0]

    box = Array(n) { IntArray(m) }

    for (i in 0 until n){
        val st = StringTokenizer(readLine())

        for (j in 0 until m){
            val tomato = st.nextToken().toInt()
            box[i][j] = tomato

            when (tomato) {
                1 -> queue.add(Node(i, j))
                0 -> unripeCount++
            }
        }
    }

    if(unripeCount == 0) {
        print(0)
        return
    }

    val day = bfs()

    print(if(unripeCount > 0) -1 else day)
}


fun bfs(): Int {
    var day = 0

    while(queue.isNotEmpty()) {
        val node = queue.poll()
        day = box[node.x][node.y]

        for(i in 0 until 4) {
            val nx = node.x + dx[i]
            val ny = node.y + dy[i]

            if(nx !in box.indices || ny !in box[0].indices || box[nx][ny] != 0) continue
            unripeCount--
            box[nx][ny] = box[node.x][node.y] + 1
            queue.offer(Node(nx, ny))
        }
    }

    return day - 1
}