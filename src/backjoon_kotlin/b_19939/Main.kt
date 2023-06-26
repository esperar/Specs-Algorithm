package backjoon_kotlin.b_19939


fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val basket = k * (k + 1) / 2
    if(n < basket) {
        println(-1)
    } else {
        if((n - basket) % k == 0){
            println(k - 1)
        } else {
            println(k)
        }
    }
}