package backjoon_kotlin.b_14501

var max = 0
var sum = 0
var arr = arrayListOf<Pair<Int,Int>>()
var n = 0

fun main() = with(System.`in`.bufferedReader()){
    n = readLine().toInt()

    for(i in 0 until n){
        val(t, p) = readLine().split(" ").map { it.toInt() }
        arr.add(Pair(t, p))
    }

    for(i in 0 until n){
        find(i, arr[i].first)
    }

    println(max)
}

fun find(index: Int, x: Int){
    if(index + x == n){
        sum += arr[index].second
        max = max.coerceAtLeast(sum)
        sum = 0
    } else if(index + x > n){
       max = max.coerceAtLeast(sum)
       sum = 0
    } else {
        sum += arr[index].second
        val tmp = sum
        for(i in index + x until n){
            sum = tmp
            find(i, arr[i].first)
        }
    }
}