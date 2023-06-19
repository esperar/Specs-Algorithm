package backjoon_kotlin.b_17413

import java.lang.StringBuilder
import java.util.*

val stack = Stack<Char>()

fun main() = with(System.`in`.bufferedReader()){
    val input = readLine()!!
    var flag = true
    val sb = StringBuilder()

    for(i in input.indices){
        val c = input[i]

        if(c == '<')
            flag = false

        if(c == '>') {
            flag = true
            sb.append(">")
            continue
        }

        if(flag){
            if(c != ' '){
                stack.push(c)
            }
        }

        if(!flag || c == ' '){
            while(stack.isNotEmpty()){
                sb.append(stack.pop())
            }
            sb.append(c)
        }
    }
    while(stack.isNotEmpty()){
        sb.append(stack.pop())
    }

    println(sb)
}