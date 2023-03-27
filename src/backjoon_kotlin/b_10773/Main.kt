package backjoon_kotlin.b_10773

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val K = readLine()!!.toInt()
    val stack = Stack<Int>()
    repeat(K){
        var input = readLine().toInt()
        if(input == 0){
            stack.pop()
        } else {
            stack.push(input)
        }
    }
    var sum = 0
    stack.forEach { sum += it }
    println(sum)
}