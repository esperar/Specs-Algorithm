package backjoon_kotlin.b_2910

fun main() = with(System.`in`.bufferedReader()) {
    val(n, c) = readLine().split(" ").map { it.toInt() }
    val numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
    val numberMap = mutableMapOf<Int, Int>()

    for(number in numbers) {
        numberMap[number] = (numberMap[number] ?: 0) + 1
    }

    for(number in numberMap.entries.sortedByDescending { it.value }.associate { it.toPair() }.keys) {
        for(j in 0 until numberMap[number]!!) {
            print("$number ")
        }
    }
}