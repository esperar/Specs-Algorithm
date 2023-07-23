package study_note.graph_search

import java.lang.StringBuilder
import java.util.*

// DFS, BFS

private var arr = Array(0) { Array(0) { 0 } }
private var visited = Array(0) { false }
private val sb = StringBuilder()

private var n = 0
private var m = 0
private var count = 0

fun dfs(node: Int){
    visited[node] = true
    sb.append("$node ")

    if(count == n) {
        return
    }

    count++

    for(i in 1..n) {
        if(arr[node][i] == 1 && !visited[node]){
            dfs(i)
        }
    }
}

fun bfs(node: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.offer(node)
    visited[node] = true
    sb.append("$node ")

    while(queue.isNotEmpty()){
        val nodeNum = queue.poll()

        for(i in 1..n){
            if(arr[nodeNum][i] == 1 && !visited[i]){
                queue.offer(i)
                visited[i] = true
                sb.append("$i ")
            }
        }
    }

    queue.clear()
}

fun main() = with(System.`in`.bufferedReader()){
    n = readLine().toInt()
    m = readLine().toInt()

    val v = readLine().toInt()

    arr = Array(n + 1) { Array(n + 1) { 0 } }
    visited = Array(n + 1) { false };

    for(i in 1..m){
        val input = readLine().split(" ").map { it.toInt() }
        val x = input[0]
        val y = input[1]

        arr[x][y] = 1
        arr[y][x] = 1
    }

    dfs(v)

    sb.append("\n")

    visited = Array(n + 1) { false };
    bfs(v);

    print(sb);
}