package backjoon_kotlin.b_9237

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine()!!.toInt()
    val trees = readLine().split(" ").map { it.toInt() }.sortedDescending()
    var result = 0

    for(i in trees.indices){
        result = result.coerceAtLeast(trees[i] + i + 1)
    }

    println(result + 1)
}