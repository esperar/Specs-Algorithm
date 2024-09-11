package backjoon_kotlin.b_4195

import java.lang.StringBuilder

lateinit var rank: IntArray
lateinit var parents: IntArray
lateinit var map: MutableMap<String, Int>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        map = mutableMapOf()
        val f = readLine().toInt()
        parents = IntArray(2 * 100_001)
        rank = IntArray(2 * 100_001)

        for(i in 1 until 2 * 100_001) {
            parents[i] = i
            rank[i] = 1
        }

        var idx = 1
        for(i in 0 until f) {
            val input = readLine().split(" ")
            for(j in 0 until 2) {
                val name = input[j]
                if(!map.containsKey(name)) {
                    map[name] = idx++
                }
            }
            val to = map[input[0]]!!
            val from = map[input[1]]!!
            val num = union(to, from)
            sb.append(num).append("\n")
        }
    }

    println(sb.toString())
}

fun find(x: Int): Int {
    if (parents[x] == x) return x
    return find(parents[x])
}

fun union(x: Int, y: Int): Int {
    val root1 = find(x)
    val root2 = find(y)
    if(root1 != root2) {
        if(root1 > root2) {
            parents[root1] = root2
            rank[root2] += rank[root1]
            return rank[root2]
        } else {
            parents[root2] = root1
            rank[root1] += rank[root2]
        }
    }
    return rank[root1]
}