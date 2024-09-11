package backjoon_kotlin.b_1717

lateinit var parents: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }.toIntArray()
    val n = nm[0]
    val m = nm[1]
    parents = IntArray(n + 1)
    for(i in 0 .. n) {
        parents[i] = i
    }

    for(i in 0 until m) {
        val (operation, a, b) = readLine().split(" ").map { it.toInt() }
        if(operation == 0) {
            // union
            union(a, b)
        } else if (operation == 1) {
            // find
            if(find(a) == find(b)) println("YES") else println("NO")
        }
    }
}

fun find(x: Int): Int {
    if(x == parents[x]) return x
    parents[x] = find(parents[x])
    return parents[x]
}

fun union(x: Int, y: Int) {
    val root1 = find(x)
    val root2 = find(y)
    parents[root2] = root1
}