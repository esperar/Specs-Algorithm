package backjoon_kotlin.b_1920

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine()!!.toInt()
    val nInput = readLine()!!.split(" ").map { it.toLong() }.toSet()
    val m = readLine()!!.toInt()
    val mInput = readLine()!!.split(" ").map { it.toLong() }
    val sb = StringBuilder()

    for(i in 0 until m){
        if(nInput.contains(mInput[i])) {
            sb.append("1\n")
        } else {
            sb.append("0\n")
        }
    }

    println(sb)
}