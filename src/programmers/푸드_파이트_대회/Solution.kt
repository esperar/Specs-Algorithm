package programmers.푸드_파이트_대회

import java.lang.StringBuilder

class Solution {
    fun solution(food: IntArray): String {
        val sb = StringBuilder()
        val foods = mutableListOf<Int>()

        for(i in 1 until food.size) {
            for(j in 0 until food[i] / 2) {
                foods.add(i)
            }
        }

        for(i in foods){
            sb.append("$i")
        }

        sb.append("0")

        for(i in foods.sortedDescending()){
            sb.append("$i")
        }

        return sb.toString()
    }
}