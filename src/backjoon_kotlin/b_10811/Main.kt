package backjoon_kotlin.b_10811

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val pot = IntArray(n + 1) { it }

    repeat(m){
        var (i, j) = readLine().split(" ").map{ it.toInt() }
        while(i < j){
            val temp = pot[i]
            pot[i++] = pot[j]
            pot[j--] = temp
        }
    }

    print(pot.copyOfRange(1, pot.size).joinToString(" "))
}