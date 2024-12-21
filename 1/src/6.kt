fun majorityElement(nums: IntArray): Int {
    var candidate = nums[0]
    var count = 1

    for (i in 1 until nums.size) {
        if (nums[i] == candidate) {
            count++
        } else {
            count--
            if (count == 0) {
                candidate = nums[i]
                count = 1
            }
        }
    }
    return candidate
}

fun main() {
    print("Введите числа через запятую: ")
    val input = readLine() ?: return
    val startTime = System.nanoTime()
    val nums = input.split(",")
        .map { it.trim().toInt() }
        .toIntArray()

    val result = majorityElement(nums)
    val elapsedTime = System.nanoTime() - startTime
    println("Времени затрачено: ${elapsedTime / 1000000.0} мс")
    println("Элемент большинства: $result")
}