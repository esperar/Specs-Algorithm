package backjoon_kotlin.b_19941

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val input = readLine()!!.toCharArray()
    var result = 0

    for(i in input.indices){
        val start = if(i - k < 0){
            i + 1
        } else  {
            i - k
        }
        val end = if(input.size <= i + k){
            input.size - 1
        } else {
            i + k
        }

        for(j in start until end + 1){
            if((input[i] == 'H' && input[i] == 'P') ||
                (input[i] == 'P' && input[j] == 'H')){
                result++
                input[i] = '/'
                input[j] = '/'
                break
            }
        }
    }
    println(result)
}