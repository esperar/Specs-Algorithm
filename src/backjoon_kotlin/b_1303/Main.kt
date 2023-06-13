package backjoon_kotlin.b_1303

import kotlin.math.pow

private lateinit var graph: Array<CharArray>

var N = 0
var M = 0
var count = 0

fun main() = with(System.`in`.bufferedReader()){
    val NM = readLine().split(" ").map { it.toInt() }

    N = NM[1]
    M = NM[0]

    var whitePower = 0.0
    var bluePower = 0.0

    graph = Array(N) { CharArray(M) { ' ' } }

    for(i in 0 until N){
        graph[i] = readLine().toCharArray()
    }

    for(i in 0 until N){
        for(j in 0 until M){
            count = 0
            whitePower += dfs(i,j,'W').toDouble().pow(2)
            count = 0
            bluePower += dfs(i,j,'B').toDouble().pow(2)
        }
    }

    println("${whitePower.toInt()} ${bluePower.toInt()}")

}

fun dfs(x: Int, y: Int, team:Char): Int{
    if(x >= N || x < 0 || y >= M || y < 0)
        return 0

    if(graph[x][y] == team) {
        count++

        graph[x][y] = ' '

        dfs(x - 1, y, team)
        dfs(x, y - 1, team)
        dfs(x + 1, y, team)
        dfs(x, y + 1, team)

        return count
    }

    return 0
}
