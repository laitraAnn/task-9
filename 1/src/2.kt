fun findIntersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = mutableSetOf<Int>()
    for (num in nums1) {
        set1.add(num)
    }

    val resultSet = mutableSetOf<Int>()
    for (num in nums2) {
        if (set1.contains(num)) {
            resultSet.add(num)
        }
    }

    return resultSet.toIntArray()
}

fun main() {
    val nums1 = intArrayOf(1, 2, 2, 1)
    val nums2 = intArrayOf(2, 2)

    val startTime1 = System.currentTimeMillis()
    val result = findIntersection(nums1, nums2)
    val endTime1 = System.currentTimeMillis()
    val duration1 = endTime1 - startTime1

    println("Результат: ${result.joinToString(", ")}")
    println("Время выполнения для первой пары: ${duration1} миллисекунд")

    val nums3 = intArrayOf(4, 9, 5)
    val nums4 = intArrayOf(9, 4, 9, 8, 4)

    val startTime2 = System.currentTimeMillis()
    val result2 = findIntersection(nums3, nums4)
    val endTime2 = System.currentTimeMillis()
    val duration2 = endTime2 - startTime2

    println("Результат: ${result2.joinToString(", ")}")
    println("Время выполнения для второй пары: ${duration2} миллисекунд")
}