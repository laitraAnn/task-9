fun main() {
    print("Введите элементы массива через запятую (например, 8,1,2,2,3): ")
    val input = readLine() ?: ""
    val nums = input.split(",").map { it.trim().toInt() }.toIntArray()
    val startTime = System.nanoTime()
    val result = Numbers(nums)
    val elapsedTime = System.nanoTime() - startTime
    println("Времени затрачено: ${elapsedTime / 1000000.0} мс")
    println("Результат: ${result.joinToString(", ")}")
}

fun Numbers(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    val count = IntArray(101)

    for (num in nums) {
        count[num]++
    }

    for (i in 1 until count.size) {
        count[i] += count[i - 1]
    }

    for (i in nums.indices) {
        result[i] = if (nums[i] == 0) 0 else count[nums[i] - 1]
    }

    return result
}