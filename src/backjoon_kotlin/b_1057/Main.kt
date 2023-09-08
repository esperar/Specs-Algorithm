package backjoon_kotlin.b_1057

fun main() = with(System.`in`.bufferedReader()) {
    var(n, k, l) = readLine().split(" ").map { it.toInt() }
    var count = 0
    while(k != l) {
        k = k / 2 + k % 2
        l = l / 2 + l % 2
        count++
    }

    print(count)
}