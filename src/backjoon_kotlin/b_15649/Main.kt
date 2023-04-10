package backjoon_kotlin.b_15649

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val visited = Array(n+1){false}
    val arr = Array(m){0}
    val sb = StringBuilder()

    fun find(len: Int){
        if(len == m){
            arr.forEach {
                sb.append(it).append(' ')
            }
            sb.append('\n')
            return
        }

        for(i in 1..n){
            if(!visited[i]){
                visited[i] = true
                arr[len] = i
                find(len+1)
                visited[i] = false
            }
        }
    }

    find(0)
    println(sb)
}

