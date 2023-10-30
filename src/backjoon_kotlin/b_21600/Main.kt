package backjoon_kotlin.b_21600

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val histogram = readLine().split(" ").map { it.toInt() }

    var max = 0
    var left = 0
    var right = left
    var sequence = 1

    while(right < n) {
        val currentHistogram = histogram[right]
        if(currentHistogram < sequence) {
            max = (right - left).coerceAtLeast(max)
            left++
            right = left
            sequence = 1
        } else {
            right++
            sequence++
        }
    }
    println(max)
}