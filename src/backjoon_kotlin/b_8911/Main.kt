package backjoon_kotlin.b_8911

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    for(i in 0 until t) {
        println(move(readLine()))
    }
}

fun move(str: String) : Int {
    var currentX = 0
    var currentY = 0
    var maxX = 0
    var maxY = 0
    var minX = 0
    var minY = 0

    var directionStatus = 0 // 북 동 남 서 0 1 2 3

    for(i in str) {
        when(i) {
            'F' -> {
                when(directionStatus) {
                    0 -> currentY += 1
                    1 -> currentX += 1
                    2 -> currentY -= 1
                    3 -> currentX -= 1
                }
            }

            'B' -> {
                when(directionStatus) {
                    0 -> currentY -= 1
                    1 -> currentX -= 1
                    2 -> currentY += 1
                    3 -> currentX += 1
                }
            }

            'L' -> {
                directionStatus--
                if(directionStatus == -1) {
                    directionStatus = 3
                }
            }

            'R' -> {
                directionStatus++
                if(directionStatus == 4) {
                    directionStatus = 0
                }
            }
            else -> return 0
        }

        maxX = maxX.coerceAtLeast(currentX)
        minX = minX.coerceAtMost(currentX)

        maxY = maxY.coerceAtLeast(currentY)
        minY = minY.coerceAtMost(currentY)
    }

    currentX = kotlin.math.abs(minX) + maxX
    currentY = kotlin.math.abs(minY) + maxY

    return currentX * currentY
}