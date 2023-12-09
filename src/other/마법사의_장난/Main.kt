package other.마법사의_장난

val dx = arrayOf(0, 0, 0, 1, -1)
val dy = arrayOf(0, 1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var answer = 0

    val board = Array(n) { IntArray(n) }

    for(i in 0 until n) {
        board[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val s = readLine().toInt()

    repeat(s) {
        val(x, y, range) = readLine().split(" ").map { it.toInt() }

        if(board[x][y] == 0) {
            board[x][y] = 1
        } else {
            board[x][y] *= 2
        }

        for (i in 1 until 5) {
            var nx = x + dx[i]
            var ny = y + dy[i]
            var count = 0

            while((nx in 0 until n && ny in 0 until n) && count < range) {
                if(board[nx][ny] == 0) {
                    board[nx][ny] = 1
                } else {
                    board[nx][ny] *= 2
                }

                nx += dx[i]
                ny += dy[i]
                count++
            }
        }
    }

    for(i in 0 until n) {
        for(j in 0 until n) {
            answer += board[i][j]
        }
    }

    println(answer)
}


