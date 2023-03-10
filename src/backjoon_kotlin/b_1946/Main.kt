package backjoon_kotlin.b_1946

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val result = arrayListOf<Int>()
    for(i in 0 until N){
        val M = readLine().toInt()
        var count = 1
        val work = arrayOfNulls<Int>(M + 1)

        for(j in 0 until M){
            val (a, b) = readLine().split(" ").map { it.toInt() }
            work[a] = b
        }

        var vot = work[1]

        for(j in 2 .. M ){
            if(work[j]!! < vot!!){
                vot = work[j]
                count++
            }
        }

        result.add(count)

    }

    for (r in result){
        println(r)
    }
}