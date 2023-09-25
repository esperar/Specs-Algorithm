package backjoon_kotlin.b_16435

fun main() = with(System.`in`.bufferedReader()) {
    var (n, l) = readLine().split(" ").map { it.toInt() }
    val fruits = readLine().split(" ").map { it.toInt() }.toIntArray()
    for(fruit in fruits.sorted()) {
        if(l >= fruit) {
            l++
        }
    }

    println(l)
}