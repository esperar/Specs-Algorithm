package study_note.sort

fun selectionSort(data: MutableList<Int>): MutableList<Int> {
    for(i in data.indices){
        var min = i
        for(j in i + 1 until data.size){
            if(data[min] > data[j]){
                min = j
            }
        }
        data[i] = data[min].also { data[min] = data[i] }
    }
    return data
}

fun main(){
    val data = mutableListOf(1,5,7,9,0,2,3)
    println(selectionSort(data).toString())
}