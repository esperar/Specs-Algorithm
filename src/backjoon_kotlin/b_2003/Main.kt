package backjoon_kotlin.b_2003

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
    var startIndex = 0
    var endIndex = 1
    var sum = numbers[0]
    var count = 0

    while(true) {
        if(sum == m) {
            count++
            sum -= numbers[startIndex]
            startIndex++
        } else if(sum < m) {
            if(endIndex < n) {
                sum += numbers[endIndex]
                endIndex++
            } else {
                break
            }
        } else {
            sum -= numbers[startIndex]
            startIndex++
        }
    }
    println(count)
}