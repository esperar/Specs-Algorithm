package backjoon_kotlin.b_9375

fun main() = with(System.`in`.bufferedReader()){
    val t = readLine().toInt()
    for(i in 0 until t){

        val map = mutableMapOf<String, Int>()
        val n = readLine().toInt()
        for(j in 0 until n){
            val type = readLine().split(" ")[1]

            if(map.containsKey(type)){
               map[type] = map.get(type)!!.plus(1)
            } else {
                map[type] = 1
            }
        }

        var result = 1
        for(v in map.values){
            result *= v + 1
        }
        println(result - 1)
    }
}