package backjoon_kotlin.b_1254

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    var answer = s.length

    for(i in s.indices) {
        if(isPallin(s.substring(i))) {
            break
        }
        answer++
    }
    println(answer)
}

private fun isPalind(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    while(start <= end) {
        if(s[start] != s[end]) return false
        start++
        end--
    }
    return true
}