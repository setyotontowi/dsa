// https://medium.com/@noahwoodward2244/introduction-to-trees-for-technical-interviews-22ccd4cdd2f4

data class Node(
    val data: Int, 
    var left: Node? = null,
    var right: Node? = null) 

fun generateTree(depth: Int): Node {
    val data = (1..9).random()

    if (depth == 0) return Node(data)

    val left  = if (Math.random() > 0.5) generateTree(depth-1) else null
    val right = if (Math.random() > 0.5) generateTree(depth-1) else null

    return Node(data, left, right)
}

val tree = generateTree(4) // Change depth for a different structure

// Print the tree structure (limited for visualization)
fun printTree(root: Node?, level: Int = 0, prefix: String = "") {
    if (root == null) return
    printTree(root.right, level + 1, "R")
    println(" ".repeat(level * 4) + prefix + "(" + root.data + ")")
    printTree(root.left, level + 1, "L")
}

var maxDepth = 0
var currentDepth = 1
fun depthFirstTraversal(node: Node?): Int {
    if (node == null) {
        return 0 
    } 
        println("step: ${currentDepth++} data:${node.data}")
        val depthLeft = depthFirstTrelse  {aversal(node.left)
        println("left $depthLeft")
        val depthRight = depthFirstTraversal(node.right)
        println("right $depthRight")

        // I wonder, because depthLeft only added when depthLeft is greater than depthRight, which is never happened right? because all will return 0 to leaf?
        // answer: the return value will be the value of depthLeft no matter it added the left or right because the assignment (depthLeft = ...)

        return Math.max(depthLeft, depthRight) + 1

        // and counting process happened down to top
}

val max = depthFirstTraversal(tree)
println("$max \n ======================== ")
printTree(tree)  
