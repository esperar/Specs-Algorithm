package backjoon_kotlin.b_1935

import java.util.Stack


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val input = readLine()
    val numbers = IntArray(n)

    for(i in 0 until n) {
        numbers[i] = readLine().toInt()
    }
    val stack = Stack<Double>()



    for(i in input) {
        if(i in 'A'..'Z') {
            stack.push(numbers[i.code - 'A'.code].toDouble())
        }
        else {
            val str2 = stack.pop().toDouble()
            val str1 = stack.pop().toDouble()

            when (i) {
                '+' -> {
                    stack.push(str1 + str2)
                }
                '-' -> {
                    stack.push(str1 - str2)
                }
                '*' -> {
                    stack.push(str1 * str2)
                }
                '/' -> {
                    stack.push(str1 / str2)
                }
            }
        }
    }
    println(String.format("%.2f", stack.pop().toDouble()))
}