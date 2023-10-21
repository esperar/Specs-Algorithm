package backjoon_kotlin.b_14465

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k, b) = readLine().split(" ").map { it.toInt() }

    val trafficLight = BooleanArray(n) { true }

    for(i in 0 until b) {
        val brokenTrafficLightNumber = readLine().toInt() - 1
        trafficLight[brokenTrafficLightNumber] = false
    }

    var left = 0
    var right = k - 1
    var min = Integer.MAX_VALUE
    var sum = 0

    while(right < n) {
        // left ~ right까지의 고장난 트래픽 라이트의 개수를 샌다. (sum)
        // sum이 min보다 작다면 min = sum
        for(i in left .. right) {
            if(!trafficLight[i])
                sum++
        }

        if(min > sum) {
            min = sum
        }

        left++
        right++
        sum = 0
    }

    println(min)
}