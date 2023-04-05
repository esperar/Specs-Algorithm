package backjoon_kotlin.b_1269

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val set1 = mutableSetOf<Int>()
    val set2 = mutableSetOf<Int>()

    set1.addAll(readLine().split(" ").map { it.toInt() })
    set2.addAll(readLine().split(" ").map { it.toInt() })

    val subTractSet1 = set1.subtract(set2)
    val subTractSet2 = set2.subtract(set1)

    println(subTractSet1.size + subTractSet2.size)
}