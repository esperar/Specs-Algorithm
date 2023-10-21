package backjoon_kotlin.b_2559

fun main() = with(System.`in`.bufferedReader()) {
    val(n, k) = readLine().split(" ").map { it.toInt() }
    val temperature = readLine().split(" ").map { it.toInt() }.toIntArray()
    var max = 0
    var left = 0
    var right = k - 1
    var sum = 0

    if(k == n) {
        println(temperature.sum())
        return
    }

    if(k == 1) {
        println(temperature.max())
        return
    }

    for(i in left ..right) {
        sum += temperature[i]
    }

    if(max < sum) {
        max = sum
    }

    while(temperature.size - 1 > right) {
        // temperature[left] 값을 빼고 temperature[right++]값을 더한다
        sum -= temperature[left++]
        sum += temperature[++right]

        if(sum > max) {
            max = sum
        }
    }
    println(max)
}