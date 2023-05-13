package backjoon_kotlin.b_10610

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val k = scan.next()
    val arrInt = IntArray(k.length)
    var arrTotalCount = 0

    for (i in k.indices) {
        arrInt[i] = k[i].toInt() - 48
        arrTotalCount += arrInt[i]
    }
    arrInt.sort()
    if (arrTotalCount % 3 == 0 && arrInt[0] == 0) {
        for (i in k.length - 1 downTo 0) {
            print(arrInt[i])
        }
    } else {
        println(-1)
    }
}
