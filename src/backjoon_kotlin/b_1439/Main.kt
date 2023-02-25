package backjoon_kotlin.b_1439

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val input = readLine()
    var currentProperty: Char = input[0]
    var oneCount = 0
    var zeroCount = 0

    for(i in input.indices){

        if(input[i] != currentProperty && input[i] == '1'){
            currentProperty = '1'
            oneCount += 1
        } else if(input[i] != currentProperty && input[i] == '0'){
            currentProperty = '0'
            zeroCount += 1
        }
    }

    println(if(oneCount > zeroCount) oneCount else zeroCount)
}