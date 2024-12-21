fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    val totalSum = n * (n + 1) / 2
    val arraySum = nums.sum()
    return totalSum - arraySum
}

fun main() {
    print("Введите различные числа от 0, разделенные запятыми (например: 3,0,1): ")
    val input = readLine() ?: return

    val nums = input.split(",").mapNotNull { it.trim().toIntOrNull() }.toIntArray()
    val startTime = System.nanoTime()
    if (nums.distinct().size != nums.size || nums.any { it < 0 || it > nums.size }) {
        println("Ошибка: все числа должны быть уникальными и находиться в диапазоне [0, n].")
        return
    }
    val elapsedTime = System.nanoTime() - startTime
    println("Времени затрачено: ${elapsedTime / 1000000.0} мс")
    val missing = missingNumber(nums)
    println("Отсутствующее число: $missing")
}
