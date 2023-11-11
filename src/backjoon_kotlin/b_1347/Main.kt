package backjoon_kotlin.b_1347

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val order = readLine()
    val miro = Array(101) { CharArray(101) { '#' } }
    var currentDirection = 2

    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    var minX = 50
    var minY = 50
    var maxX = 50
    var maxY = 50

    miro[50][50]= '.' // 시작점을 가운데로

    var tempX = 50
    var tempY = 50

    for(i in 0 until n) {
        when (order[i]) {
            'F' -> {
                tempX += dx[currentDirection]
                tempY += dy[currentDirection]
                miro[tempX][tempY] = '.'

                minX = minX.coerceAtMost(tempX)
                minY = minY.coerceAtMost(tempY)
                maxX = maxX.coerceAtLeast(tempX)
                maxY = maxY.coerceAtLeast(tempY)
            }
            'R' -> {
                currentDirection = (currentDirection + 1) % 4
            }

            'L' -> {
                if(currentDirection == 0) currentDirection = 3 else currentDirection--
            }
        }
    }

    val sb = StringBuilder()
    for(i in minX .. maxX) {
        for(j in minY .. maxY) {
            sb.append(miro[i][j])
        }
        sb.append("\n")
    }

    println(sb)
}