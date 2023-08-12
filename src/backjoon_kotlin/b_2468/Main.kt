package backjoon_kotlin.b_2468

var n = 0

private lateinit var graph: Array<IntArray>
lateinit var visited: Array<BooleanArray>
val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, -1, 0, 1)


fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    graph = Array(n + 1) { IntArray(n + 1) }

    var maxHeight = 0
    for(i in 0 until n) {
        graph[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
        val inputMaxHeight = graph[i].max()
        if(maxHeight < inputMaxHeight) {
            maxHeight = inputMaxHeight
        }
    }

    var result = 0
    for(height in 0 ..maxHeight) {
        visited = Array(n + 1) { BooleanArray(n + 1) }
        var count = 0
        for(i in 0 until n){
            for(j in 0 until n){
                if(!visited[i][j] && graph[i][j] > height)
                    count += dfs(i, j, height)
            }
        }
        result = result.coerceAtLeast(count)
    }

    println(result)
}

fun dfs(x: Int, y: Int, height: Int) : Int {
    visited[x][y] = true
    for(i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) continue;
        if(visited[nx][ny]) continue

        if(graph[nx][ny] > height) {
            dfs(nx, ny, height)
        }
    }
    return 1
}