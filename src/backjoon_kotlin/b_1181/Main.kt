package backjoon_kotlin.b_1181

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val words = mutableSetOf<String>()

    for(i in 0 until n) {
        words.add(readLine())
    }

    val result = words.sortedWith(Comparator { a, b ->
        when {
            a.length < b.length -> -1
            a.length == b.length -> when {
                a < b -> -1
                else -> 1
            }
            else -> 1
        }
    })

    for(i in result){
        println(i)
    }
}