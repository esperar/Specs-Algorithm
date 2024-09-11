package study_note.union_find

import java.lang.StringBuilder

lateinit var parents: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val sb = StringBuilder()
    parents = IntArray(k + 1)
    for(i in 1 .. k) {
        parents[i] = i
    }

    for(i in 0 until k) {
        val operation = readLine().split(" ").map { it.toInt() }.toIntArray()

        if(operation[0] == 0) {
            union(operation[1], operation[2])
        } else if(operation[0] == 1) {
            sb.append(find(operation[1]) == find(operation[2])).append("\n")
        }
    }

    println(sb)
}

fun find(x: Int): Int {
    if(parents[x] == x) return x
    parents[x] = find(parents[x])
    return parents[x]
}

fun union(x: Int, y: Int) {
    val root1 = find(x)
    val root2 = find(y)
    parents[root2] = root1
}