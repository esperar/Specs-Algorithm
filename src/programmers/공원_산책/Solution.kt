package programmers.공원_산책

class Solution {

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var position =  mutableListOf(0, 0)

        for(i in park.indices){
            for(j in park[i].indices){
                if(park[i][j] == 'S')
                    position = mutableListOf(i, j)
            }
        }

        val directions = mapOf(
            'E' to (0 to 1),
            'W' to (0 to -1),
            'N' to (-1 to 0),
            'S' to (1 to 0)
        )

        for((direction, distance) in routes.map { it[0] to it.drop(2).toInt() }){

            val prevPos = position.toMutableList()

            for(each in 0 until distance) {
                position[0] += directions[direction]!!.first
                position[1] += directions[direction]!!.second

                if(!(0 <= position[0] && position[0] < park.size &&
                            0 <= position[1] && position[1] < park[0].length &&
                            park[position[0]][position[1]] != 'X')) {
                    position = prevPos
                    break
                }
            }
        }
        return position.toIntArray()
    }
}