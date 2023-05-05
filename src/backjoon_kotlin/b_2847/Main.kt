package backjoon_kotlin.b_2847

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val stageScore = mutableListOf<Int>()
    var count = 0
    repeat(n){
        stageScore.add(readLine().toInt())
    }
    for (i in stageScore.size - 1 downTo 1) {
        while (stageScore[i] <= stageScore[i - 1]){
            stageScore[i - 1]--
            count++
        }
    }
    println(count)
}