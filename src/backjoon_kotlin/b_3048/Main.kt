package backjoon_kotlin.b_3048

fun main() = with(System.`in`.bufferedReader()) {
    val (n1, n2) = readLine().split(" ").map { it.toInt() }
    val group1 = readLine().reversed()
    val group2 = readLine()
    val second = readLine().toInt()
    val direction = IntArray(n1 + n2)

    for(i in 0 until n1) {
        direction[i] = 1
    }

    for(i in n1 until n1 + n2) {
        direction[i] = 2
    }

    val groupRecruit = (group1 + group2).toCharArray()

    repeat(second) {
        var i = 0
        while(i < n1 + n2 - 1) {
            if(direction[i] == 1 && direction[i+1] == 2){
                groupRecruit[i] = groupRecruit[i + 1]
                    .also { groupRecruit[i + 1] = groupRecruit[i] }

                direction[i] = direction[i + 1]
                    .also { direction[i + 1] = direction[i] }
                i++
            }
            i++
        }
    }

    println(groupRecruit.joinToString(separator = ""))
}