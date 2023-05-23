package backjoon_kotlin.b_10451

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()){
    val t = readLine()!!.toInt()
    val sb = StringBuilder()
    repeat(t){
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }
        var result = 0
        val visited = BooleanArray(n)
        for(i in 0 until n){
            if(visited[i]) continue
            dfs(i, arr, visited)
            result++
        }
        sb.append("${result}\n")
    }
    println(sb)
}

fun dfs(index: Int, arr: List<Int>, visited: BooleanArray){
    visited[index] = true
    val next = arr[index] - 1
    if(visited[next]) return
    dfs(next, arr, visited)
}