package backjoon_kotlin.b_2750

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = mutableListOf<Int>()
    repeat(n) {
        numbers.add(readLine().toInt())
    }

    for(i in 0 until n - 1) {
        for(j in 0 until n - 1 - i) {
            if(numbers[j] > numbers[j + 1]){
                val temp = numbers[j]
                numbers[j] = numbers[j + 1]
                numbers[j + 1] = temp
            }
        }
    }

    println(numbers.joinToString(separator = " "))
}