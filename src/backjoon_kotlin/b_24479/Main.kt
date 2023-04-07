package backjoon_kotlin.b_24479

import java.io.BufferedReader
import java.io.InputStreamReader

var visited = intArrayOf()
var order = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (N, M, R) = readLine().split(" ").map { it.toInt() }
    val graph = Array<MutableList<Int>>(N) { mutableListOf() }

    repeat(M){
        readLine().split(" ").map { it.toInt() - 1 }.let{
            graph[it.first()].add(it.last())
            graph[it.last()].add(it.first())
        }
    }

    graph.forEach { it.sort() }

    visited = IntArray(N) { order }

    dfs(graph, R - 1)

    visited.forEach { println(it) }
}

fun dfs(graph: Array<MutableList<Int>> ,R: Int){
    visited[R] = ++order
    graph[R].forEach {
        if(visited[it] == 0)
            dfs(graph, it)
    }
}