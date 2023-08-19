package backjoon_kotlin.b_2583

private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

private var n = 0
private var m = 0
private var k = 0

private val dx = arrayOf(1, 0, -1, 0)
private val dy = arrayOf(0, -1, 0, 1)
private val countList = mutableListOf<Int>()

fun main() = with(System.`in`.bufferedReader()) {

    val input = readLine().split(" ").map { it.toInt() }

    m = input[0]
    n = input[1]
    k = input[2]

    graph = Array(m) { IntArray(n) }
    visited = Array(m) { BooleanArray(n) }

    repeat(k) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        for(i in y1 until y2) {
            for(j in x1 until x2) {
                graph[i][j] = 1
            }
        }
    }

    for(i in 0 until m) {
        for(j in 0 until n) {
            if(graph[i][j] == 0 && !visited[i][j]) {
                countList.add(0)
                dfs(i, j)
            }
        }
    }

    println(countList.size)
    for(i in countList.sorted()) {
        print("$i ")
    }

}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true
    countList[countList.size - 1]++

    for(i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1) continue

        if(graph[nx][ny] == 0 && !visited[nx][ny]) {
            dfs(nx, ny)
        }
    }
}