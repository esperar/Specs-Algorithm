package backjoon_kotlin.b_1427

fun main() = with(System.`in`.bufferedReader()) {
    val numbers = readLine().map { it.digitToInt() }.toIntArray()
    for(i in numbers.indices) {
        var max = i
        for(j in i + 1 until numbers.size) {
            if(numbers[j] > numbers[max]) {
                max = j
            }
        }
        if(numbers[max] > numbers[i]) {
            val temp = numbers[i]
            numbers[i] = numbers[max]
            numbers[max] = temp
        }
    }
    println(numbers.joinToString(separator = ""))
}