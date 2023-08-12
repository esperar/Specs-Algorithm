package backjoon_kotlin.b_10814

data class User(val age: Int, val name: String, val order: Int)

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()

    val userList = mutableListOf<User>()

    for(i in 0 until n) {
        val input = readLine().split(" ")
        userList.add(User(input[0].toInt(), input[1], i))
    }

    for (user in userList.sortedWith(compareBy({ it.age }, { it.order })) ) {
        println("${user.age} ${user.name}")
    }
}