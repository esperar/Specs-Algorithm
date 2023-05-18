package backjoon_kotlin.b_9095

fun main() = with(System.`in`.bufferedReader()){
    val t = readLine()!!.toInt()

    val ans = MutableList(11,{ i -> i })

    ans[1] = 1
    ans[2] = 2
    ans[3] = 4

    repeat(t){
        val N = readLine()!!.toInt()

        for(i in 4..N){
            ans[i] = ans[i - 3] + ans[i - 2] + ans[i - 1]
        }
        println(ans[N])
    }
}