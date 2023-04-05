package backjoon_kotlin.b_1764

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val people = mutableMapOf<String, Int>()
    val result = mutableListOf<String>()

    repeat(N){
        people[readLine()] = 1
    }

    repeat(M){
        val input = readLine()
        if(people.containsKey(input)){
            result.add(input)
        }
    }

    result.sort()
    println(result.size)
    result.forEach{
        println(it)
    }
}