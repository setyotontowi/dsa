fun twoSum(nums: List<Int>, target: Int): Pair<Int, Int> {
    val map = mutableMapOf<Int, Int>()
    var first = 0
    var second = 0

    nums.forEach { 
        val spare = target - it
        map[it] = spare
        if ((map[spare] != null) && (spare != it)) {
            first = spare
            second = it
        }
    }

    return Pair(first, second)
}

val list = listOf(1, 2, 3, 4, 5)
val pair = twoSum(list, 10)
println("${pair.first}, ${pair.second}")