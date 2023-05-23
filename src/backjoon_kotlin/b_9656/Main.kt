package backjoon_kotlin.b_9656

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    println(if(n % 2 == 0) "SK" else "CY")
}