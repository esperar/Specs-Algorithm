package backjoon_kotlin.b_11724

private lateinit var graph: Array<ArrayList<Int>>
private lateinit var visited: BooleanArray

var n = 0
var m = 0
var count = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    graph = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)

    for(i in 0 until m) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    for(i in 1 .. n) {
        if (!visited[i]) {
            count++
            dfs(i)
        }
    }
    println(count)
}



fun dfs(v: Int) {
    if(visited[v]) {
        return
    }
    visited[v] = true
    for(i in graph[v]) {
        if(!visited[i]) {
            dfs(i)
        }
    }
}