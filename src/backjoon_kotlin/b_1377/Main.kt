package backjoon_kotlin.b_1377

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = arrayOfNulls<NumberAndIndex>(n)
    for(i in 0 until n) {
        numbers[i] = NumberAndIndex(i, readLine().toInt())
    }

    Arrays.sort(numbers)

    var max = 0
    for(i in 0 until n) {
        if(max < numbers[i]!!.index - i) {
            max = numbers[i]!!.index - i
        }
    }
    println(max + 1)
}

data class NumberAndIndex(val index: Int, val number: Int) : Comparable<NumberAndIndex> {

    override fun compareTo(other: NumberAndIndex): Int {
        return this.number - other.number
    }
}