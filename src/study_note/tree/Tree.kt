package study_note.tree

import java.util.Random

class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}

class NodeMgmt(var head: Node) {

    fun insert(value: Int){
        var currentNode: Node? = head
        while (true){
            if (value < currentNode!!.value) {
                if(currentNode!!.left != null)
                    currentNode = currentNode!!.left
                else {
                    currentNode!!.left = Node(value)
                    break
                }
            }
            else {
                if(currentNode!!.right != null)
                    currentNode = currentNode.right
                else {
                    currentNode.right = Node(value)
                    break
                }
            }
        }
    }

    fun search(value: Int): Boolean {
        var currentNode: Node? = head
        while (true) {
            if (currentNode!!.value == value) {
                return true
            } else if (value < currentNode.value) {
                currentNode = currentNode.left
            } else {
                currentNode = currentNode.right
            }
        }
        return false
    }

    fun delete(value: Int): Boolean{
        var searched = false
        var currentNode: Node? = head
        var parentNode: Node? = head

        while(currentNode != null){
            if(currentNode?.value == value){
                searched = true
                break
            } else if(value < currentNode.value){
                parentNode = currentNode
                currentNode = currentNode.left
            } else {
                parentNode = currentNode
                currentNode = currentNode.right
            }
        }

        if(!searched) return false

        if(currentNode?.left == null && currentNode?.right == null){
            if(value < parentNode!!.value){
                parentNode.left = null
            } else {
                parentNode.right = null
            }
        }

        if(currentNode?.left != null && currentNode?.right == null){
            if(value < currentNode.value){
                parentNode?.left =  currentNode?.left
            } else {
                parentNode?.right = currentNode?.left
            }
        } else if(currentNode?.left == null && currentNode?.right != null){
            if(value < currentNode.value){
                parentNode?.left = currentNode?.right
            } else {
                parentNode?.right = currentNode?.right
            }
        }

        if(currentNode?.left != null && currentNode?.right != null){
            if(value < parentNode!!.value){
                var changeNode = currentNode.right
                var changeNodeParent = currentNode.right

                while(changeNode?.left != null){
                    changeNodeParent = changeNode
                    changeNode = changeNode.left
                }

                if(changeNode?.right != null)
                    changeNodeParent?.left = changeNode?.right
                else
                    changeNodeParent?.left = null

                parentNode.left = changeNode
                changeNode?.right = currentNode.right
                changeNode?.left = currentNode.left
            }
        } else {
            var changeNode = currentNode?.right
            var changeNodeParent = currentNode?.right
            while (changeNode?.left != null){
                changeNodeParent = changeNode
                changeNode = changeNode.left
            }

            if(changeNode?.right != null) {
                changeNodeParent?.left = changeNode?.right
            } else {
                changeNodeParent?.left = null
            }

            parentNode?.left = changeNode
            changeNode?.right = currentNode?.left
            changeNode?.right = currentNode?.right
        }

        return true
    }
}

fun main() {
    val head = Node(500)
    val BST = NodeMgmt(head)
    val random = Random()
    val insertSet = hashSetOf<Int>()

    while(insertSet.size != 100){
        insertSet.add(random.nextInt(101))
    }

    for(i in insertSet){
        BST.insert(i)
    }

    for(num in insertSet){
        if(!BST.search(num)){
            print("searched Fail! $num")
        }
        println("$num")
    }

    val deleteSet = hashSetOf<Int>()
    val iterator = insertSet.iterator()
    for(i in 0 until 10){
        if(iterator.hasNext()){
            deleteSet.add(iterator.next())
        }
    }

    for(deleteNum in deleteSet){
        if(!BST.search(deleteNum))
            println("searched faild $deleteNum")
    }

}