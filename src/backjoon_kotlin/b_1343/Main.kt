package backjoon_kotlin.b_1343

fun main() = with(System.`in`.bufferedReader()){
    val input = readLine()
        .replace("XXXX", "AAAA")
        .replace("XX", "BB")
    println(if('X' in input) -1 else input)
}