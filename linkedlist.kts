class Node(val data: Int) {
    var next: Node? = null

    override fun toString(): String{
        return data.toString()
    }
}

lateinit var head: Node

fun insertFront(data: Int) {
    val node = Node(data)
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
    var last = head
    while(last.next != null) {
        last = last.next?:break;
    }

    last.next = node
}

head = Node(0)
for(i in 1..10) {
    insertBack(i)
}

while (head != null) {
    println(head)
    head = head.next?:break
}
