package backjoon_kotlin.b_1449

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    val pipe = BooleanArray(1001) { true }
    val input = readLine().split(" ").map { it.toInt() }
    var answer = 0

    for(i in input) {
        pipe[i] = false
    }

    for(i in 0 until 1001) {
        if(!pipe[i]) {
            answer++
            for(j in 1 until l) {
                if(i + j in 0 until 1001)
                pipe[i + j] = true
            }
        }
    }

    println(answer)

}