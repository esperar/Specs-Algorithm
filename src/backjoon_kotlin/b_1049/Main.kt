package backjoon_kotlin.b_1049

fun main() = with(System.`in`.bufferedReader()) {
    var (n, m) = readLine().split(" ").map { it.toInt() }
    val packagePrice = mutableListOf<Int>()
    val singlePrice = mutableListOf<Int>()

    for(i in 0 until m) {
        val input = readLine().split(" ").map { it.toInt() }
        packagePrice.add(input[0])
        singlePrice.add(input[1])
    }

    var minPrice = 100000
    val minPackagePrice = packagePrice.min()
    val minSinglePrice = singlePrice.min()

    if(minSinglePrice * n < minPrice) {
        minPrice = minSinglePrice * n
    }

    if(minPackagePrice * (((n - 1) / 6) + 1) < minPrice) {
        minPrice = minPackagePrice * (((n - 1) / 6) + 1)
    }

    if (minPackagePrice * (n / 6) + minSinglePrice * (n % 6) < minPrice) {
        minPrice = minPackagePrice * (n / 6) + minSinglePrice * (n % 6)
    }

    println(minPrice)
}