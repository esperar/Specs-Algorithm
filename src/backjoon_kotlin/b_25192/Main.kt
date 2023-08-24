package backjoon_kotlin.b_25192

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var users = HashSet<String>()
    var count = 0
    repeat(n) {
        readLine().also {
            if (it == "ENTER") {
                users = HashSet()
                return@repeat
            }
            if (users.add(it)) count++
        }
    }

    println(count)
}