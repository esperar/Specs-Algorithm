package study_note.sort

fun insertSort(data: MutableList<Int>): MutableList<Int>{
    for(i in 1 until data.size){
        var index = i
        val temp = data[i]
        while (index > 0 && data[index - 1] > temp){
            data[index] = data[index - 1]
            index--
        }
        data[index]= temp
    }
    return data
}

fun main() {
    val data = mutableListOf(2,6,8,4,3,9)
    println(insertSort(data).toString())
}