fun main() {
    print("Введите числа через запятую: ")
    val input = readLine() ?: return
    val nums = input.split(",").map { it.trim().toInt() }
    val startTime = System.nanoTime()
    val hasDuplicates = hasDuplicate(nums)
    val elapsedTime = System.nanoTime() - startTime
    println("Времени затрачено: ${elapsedTime / 1000000.0} мс")
    println("Результат: $hasDuplicates")
}

fun hasDuplicate(nums: List<Int>): Boolean {
    val seen = mutableSetOf<Int>()
    for (num in nums) {
        if (!seen.add(num)) {
            return true
        }
    }
    return false
}