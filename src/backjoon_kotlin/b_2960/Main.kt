package backjoon_kotlin.b_2960

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val numbers = BooleanArray(n + 1)
    numbers[1] = true
    var count = 0

    for(i in 2 .. n) {
        for(j in i .. n step i) {
            if(numbers[j]) continue
            count++
            numbers[j] = true

            if(count == k) {
                println(j)
                return
            }
        }
    }

}