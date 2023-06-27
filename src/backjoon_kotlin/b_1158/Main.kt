package backjoon_kotlin.b_1158

import java.lang.StringBuilder
import java.util.LinkedList

fun main() {
    val stringBuilder = StringBuilder()

    val (number , sequenceNumber) = readLine()!!.split(" ").map { it.toInt() }
    val numberQueue = LinkedList<Int>(Array<Int>(number){it+1}.toList())

    var index : Int = -1
    while (numberQueue.isNotEmpty()) {
        index = (index + sequenceNumber) % numberQueue.size
        stringBuilder.append(numberQueue.removeAt(index--)).append(", ")
    }

    with(stringBuilder) {
        this.deleteCharAt(this.length - 1)
        this.deleteCharAt(this.length - 1)
        this.insert(0, '<')
        this.insert(this.length, '>')
    }

    println(stringBuilder.toString())
}