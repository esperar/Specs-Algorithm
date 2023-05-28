package backjoon_kotlin.b_2178

import java.util.*

lateinit var arr: Array<IntArray>
lateinit var visited: Array<BooleanArray>

var dx = arrayListOf(-1, 0, 1, 0)
var dy = arrayListOf(0, -1, 0, 1)

var n = 0
var m = 0

data class Node(var x: Int, var y: Int)

fun main() = with(System.`in`.bufferedReader()){
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    arr = Array(n){ IntArray(m) }
    visited = Array(n){ BooleanArray(m) }

    for(i in 0 until n){
        arr[i] = readLine().map { it.digitToInt() }.toIntArray()
    }
    visited[0][0] = true
    bfs(0, 0)
    println(arr[n - 1][m - 1])
}

fun bfs(x: Int, y: Int){
    val queue: Queue<Node> = LinkedList()
    queue.offer(Node(x, y))

    while(queue.isNotEmpty()){
        val node: Node = queue.poll()
        for(i in 0 until 4){
            val nx = node.x + dx[i]
            val ny = node.y + dy[i]

            if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue
            if(visited[nx][ny] || arr[nx][ny] == 0)
                continue

            queue.offer(Node(nx, ny))
            arr[nx][ny] = arr[node.x][node.y] + 1
            visited[nx][ny] = true
        }
    }
}