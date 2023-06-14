package backjoon_kotlin.b_1926

import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

var n = 0
var m = 0

var dx = arrayListOf(0, 0, -1, 1)
var dy = arrayListOf(1, -1, 0, 0)

var result = 0
var cnt = 0

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()){
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    graph = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    for(i in 0 until n){
        graph[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for(i in 0 until n){
        for(j in 0 until m){
            if(!visited[i][j] && graph[i][j] == 1){
                cnt++
                bfs(i,j)
            }
        }
    }

    println(cnt)
    println(result)
}

fun bfs(x: Int, y: Int){
    var count = 0
    val queue: Queue<Node> = LinkedList()
    queue.offer(Node(x,y))
    visited[x][y] = true

    while(queue.isNotEmpty()){
        for(i in 0 until queue.size){
            count++
            val temp = queue.poll()
            for(j in 0 until 4){
                val nx = temp.x + dx[j]
                val ny = temp.y + dy[j]

                if(nx >= n || nx < 0 || ny >= m || ny < 0) continue
                if(visited[nx][ny] || graph[nx][ny] == 0) continue

                queue.offer(Node(nx, ny))
                visited[nx][ny] = true
            }
        }
    }

    if(result < count)
        result = count
}