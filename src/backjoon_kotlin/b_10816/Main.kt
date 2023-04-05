package backjoon_kotlin.b_10816

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val myCard = mutableMapOf<Int, Int>()
    val myCardInput = readLine().split(" ").map { it.toInt() }

    for(i in myCardInput) {
        if (myCard.containsKey(i)) {
            myCard[i] = myCard.getValue(i) + 1
        } else{
            myCard[i] = 1
        }
    }
    val sb = StringBuilder()
    val M = readLine().toInt()
    val cardInput = readLine().split(" ").map { it.toInt() }

    for(card in cardInput){
        if(myCard.containsKey(card)){
            sb.append("${myCard.getValue(card)} ")
        } else{
            sb.append("0 ")
        }
    }

    println(sb)
}