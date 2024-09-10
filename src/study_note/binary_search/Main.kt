package study_note.binary_search

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)
    println(arr.binarySearch(3))
}

fun IntArray.binarySearch(value: Int): Int {
    var start = 0
    var last = this.lastIndex
    val mid = (start + last) / 2
    while(start <= last) {
        when {
            this[mid] > value -> start = mid + 1
            this[mid] < value -> last = mid - 1
            this[mid] == value -> return mid
        }
    }
    return - 1
}