import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val nums1 = intArrayOf(4, 9, 5)
    val nums2 = intArrayOf(9, 4, 9, 8, 4)

    val timeWithLibrary = measureTimeMillis {
        val result = intersection(nums1, nums2)
        println("Пересечение с использованием библиотеки: ${result.toList()}")
    }

    val timeWithoutLibrary = measureTimeMillis {
        val result = intersectionWithoutLibrary(nums1, nums2)
        println("Пересечение без использования библиотеки: ${result.toList()}")
    }

    println("Время с использованием библиотеки: $timeWithLibrary мс")
    println("Время без использования библиотеки: $timeWithoutLibrary мс")
}

suspend fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    return withContext(Dispatchers.Default) {
        nums1.toSet().intersect(nums2.toSet()).toIntArray()
    }
}

suspend fun intersectionWithoutLibrary(nums1: IntArray, nums2: IntArray): IntArray {
    return withContext(Dispatchers.Default) {
        val resultSet = mutableSetOf<Int>()
        val nums2Set = nums2.toSet()
        for (num in nums1) {
            if (num in nums2Set) {
                resultSet.add(num)
            }
        }
        resultSet.toIntArray()
    }
}