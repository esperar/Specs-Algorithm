package backjoon_kotlin.b_1969

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val dna = Array(N) { readLine() }

    var count = 0
    var result = ""

    for (i in 0 until M) {
        val acgt = IntArray(4) { 0 }
        for (j in 0 until N) {
            when (dna[j][i]) {
                'A' -> acgt[0]++
                'C' -> acgt[1]++
                'G' -> acgt[2]++
                else -> acgt[3]++
            }
        }

        val max = acgt.maxOf { it }
        val index = acgt.indexOf(max)

        result += when (index) {
            0 -> 'A'
            1 -> 'C'
            2 -> 'G'
            else -> 'T'
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (result[j] != dna[i][j]) {
                count++
            }
        }
    }

    println(result)
    println(count)
}