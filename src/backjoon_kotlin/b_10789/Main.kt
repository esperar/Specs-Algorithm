package backjoon_kotlin.b_10789

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var arr = Array(5) { CharArray(15)}
    var max = 0
    for(i in 0..4){
        var str: String = readLine()
        if(max < str.length) max = str.length

        for (j in 0 until str.length)
            arr[i][j] = str[j]
    }

    for(i in 0 until max){
        for(j in 0..4){
            if(arr[j][i] == '\u0000') continue;
            print(arr[j][i])
        }
    }
}