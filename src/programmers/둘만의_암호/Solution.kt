package programmers.둘만의_암호

import java.lang.StringBuilder

class Solution {

    fun solution(s: String, skip: String, index: Int): String {
        val answer = StringBuilder()

        for(c in s) {
            var count = 0
            var password = c

            while(count < index) {
                password = (password.toInt() + 1).toChar()

                if(password == '{')
                    password = 'a'

                if(!skip.contains(password))
                    count++

            }

            answer.append(password)
        }

        return answer.toString()
    }

}