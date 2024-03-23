class Node(val data: Int) {
    var next: Node? = null

    override fun toString(): String{
        return data.toString()
    }
}

class LinkedList {
    var head: Node? = null

    fun insertFront(data: Int) {
        val node = Node(data)
        if (head == null) {
            head = node
            return
        }
        node.next = head
        head = node
    }

    fun insertBack(data: Int) {
        val node = Node(data)

        // Inserting a new one if the LinkedList didn't exist
        if(head == null) {
            head = node
            return
        }

        // Looping through all the nodes to get the last item. 
        var last = head?:return
        while(last.next != null) {
            last = last.next?:break;
        }

        last.next = node
    }

    fun reversed(): LinkedList {
        val reversed = LinkedList()
        var tem = head
        while(tem != null) {
            reversed.insertFront(tem.data)
            tem = tem.next ?: break
        }

        return reversed
    }

    // this is from geeksforgeeks
    fun reversedOptimum(): LinkedList {
        var prev: Node? = null
        var current = head
        var next: Node? = null

        while(current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }

        var linkedList = LinkedList()
        linkedList.head = prev

        return linkedList
    } 

    override fun toString(): String {
        val str = StringBuilder()
        var temp = head
        while(temp != null) {
            str.append(temp.data)
            str.append(",")
            temp = temp.next?:break
        }

        return str.toString()
    }
}

val linkedList = LinkedList()
for(i in 1..10) {
    linkedList.insertFront(i)
}

var reversed = linkedList

println(reversed)

