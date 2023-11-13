package backjoon_kotlin.b_5464

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var answer = 0

    val currentParking = IntArray(n + 1) // 몇번 칸에 몇번차가 주차중인지
    val rs = IntArray(n + 1) // 주차장 무게당 요금
    val carsWeight = IntArray(m + 1) // 들어오는 자동차 - 무게

    for(i in 1 .. n) {
        rs[i] = readLine().toInt()
    }

    for(i in 1 .. m) {
        carsWeight[i] = readLine().toInt()
    }

    val carOrder: Queue<Int> = LinkedList()// 들어오는, 나가는 자동차 오더

    outer@for(i in 0 until m * 2) {
        val order = readLine().toInt()

        if(order > 0) { // 들어오는 차
            for(j in 1 .. n) {
                if(currentParking[j] == 0) {
                    currentParking[j] = order
                    continue@outer
                }
            }
            carOrder.offer(order)
        } else {
            for(j in 1 .. n) {
                if(currentParking[j] == order * (-1)) {
                    currentParking[j] = 0
                    answer += rs[j] * carsWeight[order * (-1)]
                    if(carOrder.isNotEmpty()) {
                        currentParking[j] = carOrder.poll()
                        break
                    }
                }
            }
        }
    }
    println(answer)
}