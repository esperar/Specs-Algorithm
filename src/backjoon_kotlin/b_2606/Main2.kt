package backjoon_kotlin.b_2606

private lateinit var myGraph: Array<IntArray>
private lateinit var visited: BooleanArray
private var result: Int = 0

fun main() = with(System.`in`.bufferedReader()){
    val com = readLine()!!.toInt()
    val link = readLine()!!.toInt()

    myGraph = Array(com + 1) { IntArray(com + 1) }
    visited = BooleanArray(com + 1)

    for(i in 0 until link){
        val (a,b) = readLine().split(" ").map { it.toInt() }
        myGraph[a][b] = 1
        myGraph[b][a] = 1
    }
    dfs(1)
    println(result)
}

private fun dfs(i: Int){
    if(i != 1)
        result++

    visited[i] = true

    for(j in 1 until myGraph.lastIndex + 1){
        if(!visited[j] && myGraph[i][j] == 1)
            dfs(j)
    }
}