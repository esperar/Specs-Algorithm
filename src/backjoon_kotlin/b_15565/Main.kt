package backjoon_kotlin.b_15565

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    var left = 0
    var right = 0
    var count = 0
    var minLength = Int.MAX_VALUE

    while (right < n) {
        if (arr[right++] == 1) count++

        while (count >= k) {
            minLength = minOf(minLength, right - left)
            if (arr[left++] == 1) count--
        }
    }

    if (minLength == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(minLength)
    }
}
