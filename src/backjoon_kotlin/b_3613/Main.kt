package backjoon_kotlin.b_3613

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine()
    if(input[0] == '_' || input[input.length - 1] == '_' ||
        input[0].isUpperCase()) {
        println("Error!")
        return
    }

    var toCamel = false
    var hasUpper = false
    for(i in input.indices) {
        if(input[i] == '_') {
            if(input[i - 1] == '_' || input[i + 1] == '_') {
                println("Error!")
                return
            }

            if(hasUpper) {
                println("Error!")
                return
            }

            toCamel = true
        } else {
            if(input[i].isUpperCase()) {
                if(toCamel) {
                    println("Error!")
                    return
                }
                hasUpper = true
            }

        }
    }

    if(toCamel) {
        println(snakeToCamel(input))
    } else {
        println(camelToSnake(input))
    }
 }

fun snakeToCamel(s: String): String {
    val sb = StringBuilder()
    var isNextUpper = false
    for(i in s) {
        if(isNextUpper) {
            sb.append(i.toUpperCase())
            isNextUpper = false
        } else {
            if(i == '_') {
                isNextUpper = true
            } else {
                sb.append(i)
            }
        }
    }

    return sb.toString()
}

fun camelToSnake(s: String): String {
    val sb = StringBuilder()

    for(i in s) {
        if(i.isUpperCase()) {
            sb.append('_')
            sb.append(i.toLowerCase())
        } else {
            sb.append(i)
        }
    }

    return sb.toString()
}

