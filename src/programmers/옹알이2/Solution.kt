package programmers.옹알이2

class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer = 0
        val checkList = arrayOf("aya", "ye", "woo", "ma")

        for(check in babbling){
            var temp = check
            for(i in checkList.indices){
                if(temp.contains(checkList[i] + checkList[i])){
                    continue
                } else {
                    temp = temp.replace(checkList[i], " ")
                }
            }
            if(temp.replace(" ","") == "") answer++
        }
        return answer
    }
}