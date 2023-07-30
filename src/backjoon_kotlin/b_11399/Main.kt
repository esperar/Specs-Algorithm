package backjoon_kotlin.b_11399

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val people = readLine().split(" ").map { it.toInt() }.sorted()
    var result = 0

    for(i in people.indices) {
        for(j in 0 .. i) {
            result += people[j]
        }
    }

    println(result)
}