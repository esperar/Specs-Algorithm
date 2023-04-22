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

    fun moveDown(popIdx: Int): Boolean{
        val leftChildNodeIdx = popIdx * 2
        val rightChildNodeIdx = popIdx * 2 + 1

        // 왼쪽 자식 노드도 없을 때
        if(leftChildNodeIdx >= heapList.size) {
            return false
        }

        // 왼쪽 자식 노드만 있을 때
        else if(rightChildNodeIdx >= heapList.size){
            return heapList[popIdx]!! <= heapList[leftChildNodeIdx]!!
        }

        // 왼쪽, 오른쪽 자식 모두 있을 때
        else{
            return if(heapList[leftChildNodeIdx]!! > heapList[rightChildNodeIdx]!!){
                heapList[popIdx]!! <= heapList[leftChildNodeIdx]!!
            } else {
                heapList[popIdx]!! <= heapList[rightChildNodeIdx]!!
            }
        }
    }

    fun pop(): Int?{
        if(heapList.size <= 1){
            return null
        }

        val returnedData = heapList[1]
        heapList[1] = heapList[heapList.size - 1]
        heapList.removeLast()
        var popIdx = 1

        while(moveDown(popIdx)){
            val leftChildNodeIdx = popIdx * 2
            val rightChildNodeIdx = popIdx * 2 + 1

            if(rightChildNodeIdx >= heapList.size){
                heapList[popIdx].also { heapList[leftChildNodeIdx] = heapList[popIdx] }
                popIdx = leftChildNodeIdx
            }
            else{
                if(heapList[leftChildNodeIdx]!! > heapList[rightChildNodeIdx]!!){
                    if(heapList[popIdx]!! < heapList[leftChildNodeIdx]!!){
                        heapList[popIdx].also { heapList[leftChildNodeIdx] = heapList[popIdx] }
                        popIdx = leftChildNodeIdx
                    } else {
                        heapList[popIdx].also { heapList[rightChildNodeIdx] = heapList[popIdx] }
                        popIdx = rightChildNodeIdx
                    }
                }
            }
        }

        return returnedData
    }
}