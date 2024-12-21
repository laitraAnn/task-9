import kotlin.math.pow

fun Duplicate(nums: IntArray, k: Int): Boolean {
    val indexMap = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        if (indexMap.containsKey(nums[i])) {
            val previousIndex = indexMap[nums[i]]!!
            if (i - previousIndex <= k) {
                return true
            }
        }
        indexMap[nums[i]] = i
    }
    return false
}

fun main() {
    print("Введите числа через запятую (например: 1,2,3,1): ")
    val input = readLine() ?: ""
    val nums = input.split(",").map { it.trim().toInt() }.toIntArray()

    print("Введите значение k: ")
    val k = readLine()?.toIntOrNull() ?: return
    val startTime = System.nanoTime()
    val result = Duplicate(nums, k)
    val elapsedTime = System.nanoTime() - startTime
    println("Времени затрачено: %.4f мс".format(elapsedTime / 10.0.pow(6)))
    println("Результат: $result")
}