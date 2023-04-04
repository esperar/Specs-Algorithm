package backjoon_kotlin.b_1620

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val pokemonNumberToName = mutableMapOf<Int, String>()
    val pokemonNameToNumber = mutableMapOf<String, Int>()
    val (N,M) = readLine().split(" ").map { it.toInt() }

    for(i in 1 .. N) {
        val name = readLine()
        pokemonNameToNumber[name] = i
        pokemonNumberToName[i] = name
    }

    val sb = StringBuilder()
    repeat(M){
        val input = readLine()

        if(input[0].isDigit())
            sb.append("${pokemonNumberToName[input.toInt()]}\n")
        else
            sb.append("${pokemonNameToNumber[input]}\n")

    }

    println(sb)
}