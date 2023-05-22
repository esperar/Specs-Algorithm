package backjoon_kotlin.b_2798

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val card = readLine().split(" ").map { it.toInt() }.sortedDescending().toIntArray()
    var result = 0

    for(i in 0 until n - 2){
        for(j in i + 1 until n - 1){
            for(k in j + 1 until n){
                val temp = card[i] + card[j] + card[k]
                if(m == temp){
                    result = temp
                }
                if(temp in (result + 1) until m){
                    result = temp
                }
            }
        }
    }

    println(result)
}