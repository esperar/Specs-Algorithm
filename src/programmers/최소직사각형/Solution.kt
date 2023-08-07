package programmers.최소직사각형

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var wMax = 0
        var hMax = 0
        for(s in sizes){
            wMax = maxOf(wMax, s[0], s[1]);
            hMax = hMax.coerceAtLeast(if (s[0] < s[1]) s[0] else s[1])
        }
        return wMax * hMax
    }
}