package backjoon_kotlin.b_1758

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val orders = mutableListOf<Int>()
    var money: Long = 0
    repeat(n){ orders.add(readLine()!!.toInt()) }

    orders.sortDescending()

    for(i in orders.indices){
        val tip = orders[i] - ((i + 1) - 1)
        if(tip <= 0){
            continue
        }
        money += tip
    }

    println(money)
}