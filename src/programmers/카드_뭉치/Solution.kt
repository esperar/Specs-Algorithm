package programmers.카드_뭉치

class Solution {

    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer = "Yes"
        var card1Idx = 0
        var card2Idx = 0

        for(i in goal) {
            if(card1Idx < cards1.size && cards1[card1Idx] == i) {
                card1Idx++
            } else if(card2Idx < cards2.size && cards2[card2Idx] == i){
                card2Idx++
            } else {
                answer = "No"
                break
            }
        }

        return answer
    }
}
