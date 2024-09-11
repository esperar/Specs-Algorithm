package backjoon_kotlin.b_20310

import java.lang.StringBuilder


fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine()
    var zero = 0
    var one = 0
    val sb = StringBuilder()


    for(i in input) {
        sb.append(i)
        if(i == '0') zero++
        else one++
    }

    zero /= 2
    one /= 2

    for(i in input.indices) {
        if(sb[i] == '1') {
            sb.setCharAt(i, '2')
            one--
        }
        if(one == 0) break
    }

    for(i in input.length - 1 downTo 0) {
        if(sb[i] == '0') {
            sb.setCharAt(i, '2')
            zero--
        }
        if(zero == 0) break
    }


    for(i in sb.toString().indices) {
        if(sb[i] == '1' || sb[i] == '0') print(sb[i])
    }
}