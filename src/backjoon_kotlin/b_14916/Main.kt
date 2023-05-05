package backjoon_kotlin.b_14916

fun main() = with(System.`in`.bufferedReader()){
    var n = readLine().toInt()
    var count = 0

    while (n > 0){
        if(n % 5 == 0) {
            count += n / 5
            break
        } else {
            n -= 2
            count += 1
        }
    }

    println(if(n >= 0) count else -1)
}