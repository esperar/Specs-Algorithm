package programmers.체육복

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var arr = Array(n + 1){ 1 }
        var answer = -1

        for(i in lost){
            arr[i]--
        }

        for(i in reserve){
            arr[i]++
        }

        for(i in 1..n){
            if(arr[i]==0){

                if(arr[i-1] == 2){
                    arr[i-1]--
                    arr[i]++
                }

                else if(i<n){
                    if(arr[i+1] == 2){
                        arr[i+1]--
                        arr[i]++
                    }
                }
            }
        }

        for(i in arr){
            answer += if (i == 2) 1 else i
        }

        return answer
    }
}