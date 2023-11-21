package backjoon_kotlin.b_13305

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val distance = readLine().split(" ").map { it.toLong() }.toLongArray()
    val city = readLine().split(" ").map { it.toLong() }.toLongArray()
    var sum = 0L
    var minPrice = city[0]
    sum += minPrice * distance[0]

    for(i in 1 until n - 1) {
        if(city[i] < minPrice) {
            minPrice = city[i]
        }
        sum += minPrice * distance[i]
    }

    println(sum)
}