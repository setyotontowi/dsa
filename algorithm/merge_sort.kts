class MergeSort() {

    /* DIVIDE */
    fun sort(list: MutableList<Int>, left: Int, right: Int) {
        /*
        * by definition, the value left and right remain constant. it's an index
        * for their array, regardless the sub array
        * */

        /* why left < right?
        *  because for the right sub array, the middle is in the left
        *  why not list.size >= 2?
        *  because, the list is the original array. which is why the length remains
        *  constant.
        * */
        if (left < right) {
            /* why not right/2? to find the middle?
            *  1. the value right remain constant toward the initial array, so
            *  we need left value as comparison.
            *  2. so that the function works well on both sides
            * */
            val middle = left + (right - left) / 2


            /* Why there's no single comparison in this function?
            * We divide all the array first then run the merge function
            * */
            sort(list, left, middle)
            sort(list, middle+1, right)

            /* After we divide the sublist by bringing the value of left, middle
            *  and right to the smallest sub array, we begin to merge.
            * */
            merge(list, left, middle, right)
        }
    }

    /* CONQUER */
    private fun merge(list: MutableList<Int>, left: Int, middle: Int, right: Int) {
        /* The merge function requires three module to do its job
        *  1. Temporary List - because we bring the initial array to its deepest
        *     function, so we need temporary list to do the array alteration
        *  2. The Core Sorting function - by comparing both left and right of temporary
        *     array and increase their index loop after finding the smallest value
        *  3. The Leftovers - this don't require computation. because the recursion,
        *     the smallest sub array has already sorted
        * */

        /* Temporary List*/
        val leftList = list.subList(left, middle + 1).toMutableList()
        val rightList = list.subList(middle + 1, right + 1).toMutableList()

        /* Core Sorting*/
        /* 1. find the size of each array. because the index of the middle tend to
        *     the left array, so it completed by adding 1 */
        val leftListSize = middle - left + 1
        val rightListSize = right - middle

        /* 2. initiate i, j, k value.
        *     i is for left temporary sub array
        *     j is for right temporary sub array
        *     k is for parent array
        * */
        var i = 0 ; var j = 0; var k = left

        /* 3. compare left and right array and replace the parent array*/
        while (i < leftListSize && j < rightListSize) {
            when {
                leftList[i] <= rightList[j] -> { list[k] = leftList[i]; i++ }
                rightList[j] < leftList[i]  -> { list[k] = rightList[j]; j++}
            }
            k++
        }

        /* The Leftovers
        *  fill the parent array with the remaining of sub array. it guarantee sorted
        * */
        while (i < leftListSize) {
            list[k] = leftList[i]
            i++; k++
        }

        while (j < rightListSize) {
            list[k] = rightList[j]
            j++; k++
        }

    }
}

val list = listOf(4, 5, 2, 3, 8, 5, 6)
val mutableList = list.toMutableList()

val mergeSort = MergeSort()
mergeSort.sort(mutableList, 0, list.lastIndex)

println(mutableList.toTypedArray().contentToString())
