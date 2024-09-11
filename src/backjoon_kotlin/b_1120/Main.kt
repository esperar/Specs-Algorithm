package backjoon_kotlin.b_1120

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ")
    val a = input[0]
    val b = input[1]
    var answer = a.length

    for(i in 0 .. b.length - a.length) {
        var temp = 0
        for(j in a.indices) {
            if(a[j] != b[j + i]) {
                temp++
            }
        }
        if(temp < answer) {
            answer = temp
        }
    }

    println(answer)
}