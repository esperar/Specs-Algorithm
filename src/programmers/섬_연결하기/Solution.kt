package programmers.섬_연결하기

class Solution {

    lateinit var parents: IntArray

    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        var edges = 0

        val sortedCosts = costs.sortedBy { it[2] }
        parents = IntArray(n)
        for(i in 0 until n) {
            parents[i] = i
        }

        for(edge in sortedCosts) {
            if(edges == n - 1) break
            if(find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1])
                answer += edge[2]
                edges++
            }
        }

        return answer
    }

    private fun find(x: Int): Int {
        if(parents[x] == x) return x
        parents[x] = find(parents[x])
        return parents[x]
    }

    private fun union(x: Int, y: Int) {
        val root1 = find(x)
        val root2 = find(y)
        parents[root2] = root1
    }
}