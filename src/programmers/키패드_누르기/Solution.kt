package programmers.키패드_누르기


class Solution {
    var left: Position? = null
    var right: Position? = null
    var numPos: Position? = null

    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        left = Position(3, 0)
        right = Position(3, 2)

        for (num in numbers) {
            numPos = Position((num - 1) / 3, (num - 1) % 3)
            if (num == 0)
                numPos = Position(3, 1)
            val finger = numPos!!.getFinger(hand)

            answer += finger

            if (finger == "L")
                left = numPos
            else
                right = numPos
        }

        return answer
    }

    inner class Position(var row: Int, var col: Int) {
        fun getFinger(hand: String): String {
            var finger = if (hand == "right") "R" else "L"

            if (col == 0) finger = "L"
            else if (col == 2) finger = "R"
            else {
                val leftDist = left!!.getDistance(this)
                val rightDist = right!!.getDistance(this)

                if (leftDist < rightDist)
                    finger = "L"
                else if (rightDist < leftDist)
                    finger = "R"
            }

            return finger
        }

        fun getDistance(p: Position): Int {
            return Math.abs(row - p.row) + Math.abs(col - p.col)
        }
    }
}