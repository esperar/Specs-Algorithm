package backjoon_kotlin.b_11508

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val input = mutableListOf<Int>()
    var result: Long = 0
    repeat(n){ input.add(readLine().toInt()) }

    input.reverse()

    for(i in input.indices){
        if(i % 3 != 2)
            result += input[i]

    }

    println(result)
}