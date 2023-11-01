package backjoon_kotlin.b_11399

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
    val numberSum = IntArray(n)
    for(i in 0 until n) {
        var insertPoint = i
        val insertValue = numbers[i]
        for(j in i - 1 downTo 0) {
            if(numbers[i] > numbers[j]) {
                insertPoint = j + 1
                break
            }

            if(j == 0) {
                insertPoint = 0
            }
        }
        for(j in i downTo insertPoint + 1) {
            numbers[j] = numbers[j - 1]
        }
        numbers[insertPoint] = insertValue
    }
    numberSum[0] = numbers[0]
    for(i in 1 until n) {
        numberSum[i] = numberSum[i - 1] + numbers[i]
    }

    println(numberSum.sum())
}