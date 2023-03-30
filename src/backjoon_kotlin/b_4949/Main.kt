package backjoon_kotlin.b_4949

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val list = arrayListOf<String>()
    val bracket = arrayListOf<String>()

    while(true){
        val input = readLine().toString()
        if(input == ".")
            break
        list.add(input)
    }

    for(data in list){
        val string = StringBuilder()
        for (c in data){
            when(c){
                '(',')','[',']' -> string.append(c)
            }
        }
        bracket.add(string.toString())
    }

    for(data in bracket){
        println(if(isVPS(data)) "yes" else "no")
    }

}

fun isVPS(data: String): Boolean{
    val stack = Stack<Char>()

    for(i in data){
        if(i == '(' || i == '['){
            stack.push(i)
        } else if(i == ')'){
            if(stack.isEmpty())
                return false
            val popData = stack.pop()
            if(popData != '('){
                return false
            }
        } else if(i == ']'){
            if(stack.isEmpty())
                return false
            val popData = stack.pop()
            if(popData != '['){
                return false
            }
        }
    }
    return stack.isEmpty()
}