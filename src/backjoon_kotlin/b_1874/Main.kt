package backjoon_kotlin.b_1874

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val stack = Stack<Int>()
    val N = readLine().toInt()
    var current = 1
    var result = StringBuilder()

    for(i in 0 until N){
        val x = readLine().toInt()

        while(current <= x){
            stack.push(current)
            current++
            result.append("+\n")

        }

        if(stack.peek() == x){
            stack.pop()
            result.append("-\n")
        } else{
            println("NO")
            return
        }
    }
    println(result)
}