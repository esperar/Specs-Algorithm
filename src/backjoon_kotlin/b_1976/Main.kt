package backjoon_kotlin.b_1976

lateinit var parents: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    parents = IntArray(n + 1)

    for(i in 1 .. n) {
        parents[i] = i
    }

    for(i in 1 .. n) {
        val input = readLine().split(" ").map { it.toInt() }.toIntArray()
        for(j in 1 .. n) {
            if(input[j - 1] == 1) {
                union(i, j)
            }
        }
    }

    val path = readLine().split(" ").map { it.toInt() }.toIntArray()
    for(i in 0 until path.size - 1) {
        if(find(path[i]) != find(path[i + 1])) {
            println("NO")
            return
        }
    }
    println("YES")
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