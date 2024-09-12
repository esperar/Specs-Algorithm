package backjoon_kotlin.b_4358

fun main() = with(System.`in`.bufferedReader()) {
    val treeMap = mutableMapOf<String, Double>()
    var total = 0
    var s: String = readLine()
    while(true) {
        treeMap[s] = treeMap.getOrDefault(s, 0.0) + 1
        total++
        s = readLine() ?: break
    }

    val trees = mutableListOf<String>()

    for(key in treeMap.keys) {
        trees.add(key)
    }

    trees.sort()

    for(tree in trees) {
        val percentage = String.format("%.4f", treeMap[tree]!! / total * 100)
        println("$tree $percentage")
    }
}