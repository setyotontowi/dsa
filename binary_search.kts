/* Binary Search
*  The main objective of binary search is to match the value to the middle of array
*  if there's no match, we split the list into two separated group and choose which
*  one of the list that may include the value
*
* */
fun binarySearch(sortedList: List<Int>, target: Int): Int {
    /* We should know which left and right index of the array. Should be mutable
    *  because we will alter the value in order to split the array*/
    var left = 0
    var right = sortedList.lastIndex

    /* left <= right. because we alter the right and left value by adding itself and the middle*/
    while (left <= right) {
        /* Counting the middle
        *  1. Keep in mind that (right-left) is to caution if we've split the array.
        *     because somewhere in the computation
        *  2. (+ left), so it can be used by the right list.
        *  3. the 'left' value could be come from previous 'middle'
        * */
        val middle = left + (right - left) / 2

        /* Find if the middle value is the exact target
        *  the plus and minus by one on the middle is to avoid middle to be recalculate.
        * */
        val middleValue = sortedList[middle]
        when {
            (middleValue == target) -> return middle
            (middleValue < target)  -> left  = middle + 1
            (middleValue > target)  -> right = middle - 1
        }
    }

    return -1
}

val list = listOf(0, 1, 2, 3, 4, 5, 6)
val target = 2

println(binarySearch(list, target))