package backjoon_kotlin.b_2667

import java.util.*

lateinit var arr: Array<IntArray>
lateinit var visited: Array<BooleanArray>

var N = 0
var houseCount = 0
var answer = 0

val dx = arrayListOf(1, 0, -1, 0)
val dy = arrayListOf(0, 1, 0, -1)

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()){
    N = readLine().toInt()
    arr = Array(N) { IntArray(N) }
    visited = Array(N) { BooleanArray(N) }
    val result = mutableListOf<Int>()
    for(i in arr.indices) {
        arr[i] = readLine().map { it.digitToInt() }.toIntArray()
    }

    for(i in 0 until N){
        for(j in 0 until N){
            if(!visited[i][j] && arr[i][j] == 1) {
                answer = 0
                bfs(i, j)
                visited[i][j] = true
                houseCount++
                result.add(answer)
            }
        }
    }
    result.sort()
    println(houseCount)
    for (i in result) {
        println(i)
    }
}

fun bfs(x: Int, y: Int){
    val queue: Queue<Node> = LinkedList()
    queue.offer(Node(x, y))
    visited[x][y] = true
    answer++
    while(queue.isNotEmpty()){
        val node = queue.poll()
        for(i in 0 until 4){
            val nx = node.x + dx[i]
            val ny = node.y + dy[i]

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue
            if(visited[nx][ny] || arr[nx][ny] == 0) continue

            queue.offer(Node(nx, ny))
            arr[nx][ny] = 0
            visited[nx][ny] = true
            answer++
        }
    }
}