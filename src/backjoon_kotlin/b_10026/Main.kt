package backjoon_kotlin.b_10026

import java.util.*

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)

private lateinit var grid: Array<CharArray>
private lateinit var visited: Array<BooleanArray>

var n = 0
var answer1 = 0
var answer2 = 0

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    grid = Array(n) { CharArray(n) }
    visited = Array(n) { BooleanArray(n) }

    for(i in 0 until n) {
        grid[i] = readLine().toCharArray()
    }

    for(i in 0 until n) {
        for(j in 0 until n) {
            if(!visited[i][j]) {
                bfs(i, j)
            }
        }
    }

    for(i in 0 until n) {
        visited[i].fill(false)
    }

    for(i in 0 until n) {
        for(j in 0 until n) {
            if(!visited[i][j]) {
                bfsBlindness(i, j)
            }
        }
    }

    println("$answer1 $answer2")

}

fun bfs(x: Int, y: Int) {
    val queue = LinkedList<Node>() as Queue<Node>
    queue.offer(Node(x, y))
    visited[x][y] = true

    while(queue.isNotEmpty()) {
        val target = queue.poll()
        for(i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if(nx !in 0 until n || ny !in 0 until n || visited[nx][ny])
                continue

            if(grid[nx][ny] == grid[target.x][target.y]) {
                queue.offer(Node(nx, ny))
                visited[nx][ny] = true
            }
        }
    }

    answer1++
}

fun bfsBlindness(x: Int, y: Int) {
    val queue = LinkedList<Node>() as Queue<Node>
    queue.offer(Node(x, y))
    visited[x][y] = true

    while(queue.isNotEmpty()) {
        val target = queue.poll()
        for(i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if(nx !in 0 until n || ny !in 0 until n || visited[nx][ny])
                continue

            if(grid[nx][ny] == grid[target.x][target.y]) {
                queue.offer(Node(nx, ny))
                visited[nx][ny] = true
            } else {
                if(grid[nx][ny] == 'R' && grid[target.x][target.y] == 'G') {
                    queue.offer(Node(nx, ny))
                    visited[nx][ny] = true
                } else if(grid[nx][ny] == 'G' && grid[target.x][target.y] == 'R') {
                    queue.offer(Node(nx, ny))
                    visited[nx][ny] = true
                }
            }

        }
    }

    answer2++
}