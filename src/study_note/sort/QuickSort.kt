package study_note.sort


fun qsort(array: IntArray, left: Int = 0, right: Int = array.size - 1){
    val index = partition(array, left, right)
    if(left < index - 1){
        qsort(array, left, index - 1)
    }

    if(right > index) {
        qsort(array, index, right)
    }
}

fun partition(array: IntArray, start: Int, end: Int): Int {
    var left = start
    var right = end
    val pivot = array[(left + right) / 2]

    while(left <= right){
        while(array[left] <= pivot){
            left++
        }

        while(array[right] > pivot){
            right--
        }

        if(left <= right){
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left++
            right--
        }
    }

    return left
}