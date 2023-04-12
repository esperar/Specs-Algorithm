package study_note.tree

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
}

fun main() {
    val head = Node(1)
    val BST = NodeMgmt(head)
    BST.insert(2)
    BST.insert(3)
    BST.insert(0)
    println(BST.search(2))
}