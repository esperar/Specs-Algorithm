package backjoon_kotlin.b_2531

fun main() = with(System.`in`.bufferedReader()) {
    val(n, d, k, c) = readLine().split(" ").map { it.toInt() }
    val sushi = IntArray(n)
    for(i in 0 until n) {
        sushi[i] = readLine().toInt()
    }
    var right = k - 1
    var sushiSet = mutableSetOf<Int>()
    var max = 0

    for((left, i) in (0 until n).withIndex()) {
        for(j in left ..right) {
            sushiSet.add(sushi[j % n])
        }
        sushiSet.add(c)
        val sushiSize = sushiSet.size

        if(sushiSize > max) {
            max = sushiSize
        }
        right++
        sushiSet.clear()
    }

    println(max)
}