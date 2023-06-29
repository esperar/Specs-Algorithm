package backjoon_kotlin.b_1302


fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val books = mutableMapOf<String, Int>()

    val result = mutableListOf<String>()

    for(i in 0 until n){
        val book = readLine()
        books[book] = books[book]?.plus(1) ?: 1
    }

    val max = books.values.maxOrNull()

    for((key, value) in books){
        if(value == max)
            result.add(key)
    }

    result.sort()
    println(result[0])

}