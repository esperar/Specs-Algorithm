package backjoon_kotlin.b_1448

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val arr = IntArray(n)

    for(i in 0 until n) {
        arr[i] = readLine().toInt()
    }

    val arrDesc = arr.sortedArrayDescending()

    for(i in 0 until n - 2) {
        val a = arrDesc[i]
        val b = arrDesc[i + 1]
        val c = arrDesc[i + 2]

        if(a < b + c) {
            println(a + b + c)
            return
        }
    }
    println(-1)
}