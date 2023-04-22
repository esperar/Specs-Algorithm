package study_note.heap

class Heap(private val value: Int) {

    private val heapList = mutableListOf<Int?>(null, value)

    fun moveUp(insertIdx: Int): Boolean{
        if(insertIdx == 1)
            return false

        val parentIdx = insertIdx / 2

        return heapList[insertIdx]!! > heapList[parentIdx]!!
    }

    fun insert(value: Int){
        heapList.add(value)
        var insertIdx = heapList.size - 1

        while(moveUp(insertIdx)){
            val parentIdx = insertIdx / 2
            heapList[insertIdx].also { heapList[parentIdx] = heapList[insertIdx] }
            insertIdx = parentIdx
        }
    }
}