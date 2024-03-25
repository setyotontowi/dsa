val strs = listOf("flower", "flow", "flight", "flaw")

fun longestPrefix(list: List<String>): Int {
    
    //flower f,l,o,w,e,r
    //flow   f,l,o,w        prefix=4
    //flight f,l

    var result = Integer.MAX_VALUE
    val map = mutableMapOf<Int, Char>()
    var step = 0

    list.forEach { str ->
        var prefix = 0
        println("$str")
        str.forEachIndexed { i, c ->
            print("c:$c i:$i map:${map[i]} ")
            if (c == map[i]) {
                prefix++
                print("prefix: $prefix")
            } 
            println()
            map[i] = c
        }

        if (step > 0) { 
            result = Math.min(prefix, result)
        }
        step++
        println("prefix:$prefix result:$result")
    }

    return result
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""

    // Sort the strings to easily find the common prefix
    strs.sort()
    println("strs: ${strs.contentToString()}")

    // Compare the first and last string (lexicographically)
    val prefixBuilder = StringBuilder()
    for (i in strs[0].indices) {
        println("i:$i")

        // Assuming the last string has same character with the first, since it sorted.
        if (strs[0][i] == strs[strs.size - 1][i]) {
            prefixBuilder.append(strs[0][i])
        } else {
            break
        }
    }

    return prefixBuilder.toString()
}

val arr = strs.toTypedArray()
println(longestCommonPrefix(arr))