package backjoon_kotlin.b_5212

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    val world = Array(r) { CharArray(c) }
    for(i in 0 until r) {
        world[i] = readLine().toCharArray()
    }

    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)

    var minR = 10
    var minC = 10
    var maxR = 0
    var maxC = 0

    val after = Array(r) { CharArray(c) }
    for(i in 0 until r) {
        for(j in 0 until c) {
            var count = 0
            if(world[i][j] == 'X') {
                for(k in 0 until 4) {
                    val x = i + dx[k]
                    val y = j + dy[k]

                    if((x == -1 || y == -1 || x == r || y == c) || world[x][y] == '.') {
                        count++
                    }
                }

                if(count < 3) {
                    after[i][j] = 'X'

                    minR = minR.coerceAtMost(i);
                    minC = minC.coerceAtMost(j);
                    maxR = maxR.coerceAtLeast(i);
                    maxC = maxC.coerceAtLeast(j);
                } else {
                    after[i][j] = '.'
                }
            } else {
                after[i][j] = '.'
            }
        }
    }

    val sb = StringBuilder()

    for(i in minR .. maxR) {
        for(j in minC .. maxC) {
            sb.append(after[i][j])
        }
        sb.append("\n")
    }

    println(sb)
}