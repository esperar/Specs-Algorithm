package backjoon_kotlin.b_13565

import java.util.*

val dirXY = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
var canFinish = false

fun dfs(r: Int, c: Int, graph: Array<String>) {
    graph[r] = graph[r].substring(0, c) + '2' + graph[r].substring(c + 1)

    for (dir in dirXY) {
        val nr = r + dir[0]
        val nc = c + dir[1]

        if (nr == graph.size) {
            canFinish = true
            return
        }

        if (nr < 0 || nc >= graph[0].length || nc < 0) continue
        if (graph[nr][nc] != '0') continue

        dfs(nr, nc, graph)
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()

    val graph = Array(n) { "" }
    for (i in 0 until n) {
        graph[i] = scanner.next()
    }

    for (c in 0 until m) {
        if (graph[0][c] == '0') {
            dfs(0, c, graph)
            if (canFinish) {
                println("YES")
                return
            }
        }
    }

    println("NO")
}
