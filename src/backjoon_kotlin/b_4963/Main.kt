package backjoon_kotlin.b_4963

var x = 0
var y = 0
val dx: IntArray = intArrayOf(-1,1,0,0,-1,1,-1,1)
val dy: IntArray = intArrayOf(0,0,-1,1,-1,-1,1,1)
var count = 0
var map: Array<IntArray> = arrayOf()
var visited: Array<BooleanArray> = arrayOf()

fun main() = with(System.`in`.bufferedReader()) {
    var str = readLine().split(" ")
    x = str[0].toInt()
    y = str[1].toInt()

    while ( x != 0 && y != 0 ) {
        count = 0
        map = Array(y) { IntArray(x) }
        visited = Array(y) { BooleanArray(x) }

        for ( i in 0 until y ) {
            for ( j in 0 until x ) {
                visited[i][j] = false
            }
        }

        for ( i in 0 until y ) {
            val input = readLine().split(" ")
            for ( j in 0 until x ) {
                map[i][j] = (input[j]+"").toInt()
            }
        }

        for ( i in 0 until y ) {
            for ( j in 0 until x ) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count += 1
                    dfs(i, j)
                }
            }
        }

        println(count)

        str = readLine().split(" ")
        x = str[0].toInt()
        y = str[1].toInt()
    }

}

fun dfs(yy: Int, xx: Int) {

    visited[yy][xx] = true

    for (i in 0 until 8) {
        val nx = xx + dx[i]
        val ny = yy + dy[i]

        if ( nx < 0 || ny < 0 || nx >= x || ny >= y )
            continue

        if (!visited[ny][nx] && map[ny][nx] == 1) {
            dfs(ny, nx)
        }
    }
}