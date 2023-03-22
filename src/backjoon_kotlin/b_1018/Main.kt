package backjoon_kotlin.b_1018

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val board = Array(N) { readLine()!!.toCharArray() }

    var result = Integer.MAX_VALUE

    for(i in 0..N - 8){
        for(j in 0 .. M - 8){
            var count1 = 0
            var count2 = 0

            for(k in i until i + 8){
                for(l in j until j + 8){
                    if((k + l) % 2 == 0){
                        if(board[k][l] == 'B') count1++ else count2++
                    } else {
                        if (board[k][l] == 'W') count1++ else count2++
                    }
                }
            }

            result = min(result, min(count1, count2))
        }
    }
    print(result)
}