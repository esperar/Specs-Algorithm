package backjoon_kotlin.b_1063

val dx = intArrayOf(0,0,1,-1,-1,-1,1,1)
val dy = intArrayOf(1,-1,0,0,1,-1,1,-1)

val dirStr = arrayOf("R", "L", "B", "T", "RT", "LT", "RB", "LB")

var kingX = 0
var kingY = 0

var stoneX = 0
var stoneY = 0

var N = 0

fun main(){
    val list = readln().split(' ').map{ it }

    kingY = list[0][0] - 'A'
    kingX = 7- (list[0][1] - '1')

    stoneY  = list[1][0] - 'A'
    stoneX = 7- (list[1][1] - '1')

    N = list[2].toInt()

    for(i in 0 until N){

        val command = readln()

        var curDirX = 0
        var curDirY = 0

        for(j in 0 until 8){
            if(command == dirStr[j]){
                curDirX  = dx[j]
                curDirY  = dy[j]
                break
            }
        }

        if(kingX + curDirX < 0 || kingX + curDirX >= 8
            || kingY + curDirY < 0 || kingY + curDirY >= 8) continue

        if(kingX + curDirX == stoneX && kingY + curDirY == stoneY){
            if(stoneX + curDirX < 0 || stoneX + curDirX >= 8
                || stoneY + curDirY < 0 || stoneY + curDirY >= 8) continue
            else{
                kingX += curDirX
                kingY += curDirY

                stoneX += curDirX
                stoneY += curDirY
            }
        }
        else {
            kingX += curDirX
            kingY += curDirY
        }
    }
    println("${'A'.plus(kingY)}${8 -  kingX}")
    println("${'A'.plus(stoneY)}${8 - stoneX}")
}