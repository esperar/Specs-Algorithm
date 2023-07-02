package study_note.sort

fun split(arr: ArrayList<Int>): ArrayList<Int> {

    if(arr.size <= 1) return arr

    val middle = arr.size / 2

    val left = split(ArrayList(arr.subList(0, middle)))
    val right = split(ArrayList(arr.subList(middle, arr.size)))

    return merge(left, right)
}

private fun merge(left: ArrayList<Int>, right: ArrayList<Int>): ArrayList<Int> {
    val mergedList = arrayListOf<Int>()
    var leftIndex = 0
    var rightIndex = 0

    // case 1: left right 모두 존재
    while(leftIndex < left.size && rightIndex < right.size) {
        if(left[leftIndex] < right[rightIndex]) {
            mergedList.add(left[leftIndex])
            leftIndex++
        } else {
            mergedList.add(right[rightIndex])
            rightIndex++
        }
    }

    // case 2: right만 존재
    while(rightIndex < right.size) {
        mergedList.add(right[rightIndex])
        rightIndex++
    }

    // case 3: left만 존재
    while(leftIndex < left.size){
        mergedList.add(left[leftIndex])
        leftIndex++
    }

    return mergedList
}
