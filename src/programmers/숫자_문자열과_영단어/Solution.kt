package programmers.숫자_문자열과_영단어


class Solution {
    fun solution(s: String): Int {

        var number = s

        val words = arrayOf(
            "zero", "one", "two", "three",
            "four", "five", "six",
            "seven", "eight", "nine"
        )

        for(i in words.indices) {
            number = s.replace(words[i], i.toString())
        }

        return number.toInt()
    }
}