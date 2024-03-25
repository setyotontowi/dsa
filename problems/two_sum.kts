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

fun twoSumQuickSort(nums: List<Int>, target: Int): Pair<Int, Int> {
    var leftIndex = 0
    var rightIndex = nums.lastIndex

    while(leftIndex < rightIndex) {
        val sum = nums[leftIndex] + nums[rightIndex]
        if ( sum == target) {
            return Pair(nums[leftIndex], nums[rightIndex])
        } else if (sum < target) {
            leftIndex++
        } else {
            rightIndex--
        }
    }

    return Pair(0,0)
}

val list = listOf(1, 2, 3, 4, 5)
val pair = twoSumQuickSort(list, 7)
println("${pair.first}, ${pair.second}")