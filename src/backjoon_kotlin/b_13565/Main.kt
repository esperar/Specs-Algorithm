package backjoon_kotlin.b_13565

import java.util.*

var n = 0
var m = 0
lateinit var graph: Array<IntArray>
lateinit var visited: Array<BooleanArray>
val pos = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(1, 0))
var check = false

fun main() {
    val sc = Scanner(System.`in`)

    n = sc.nextInt()
    m = sc.nextInt()

    graph = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        val str = sc.next()
        for (j in 0 until m) {
            graph[i][j] = str[j] - '0'
        }
    }

    for (i in 0 until m) {
        if (graph[0][i] == 0) {
            dfs(0, i)
        }
    }

    println(if (check) "YES" else "NO")
}

fun dfs(row: Int, col: Int) {
    visited[row][col] = true
    if (row == n - 1 && graph[row][col] == 0) {
        check = true
        return
    }

    for (i in pos.indices) {
        val nr = row + pos[i][0]
        val nc = col + pos[i][1]

        if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && graph[nr][nc] == 0) {
            dfs(nr, nc)
        }
    }
}
