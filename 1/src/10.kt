import kotlin.math.pow

fun lengthOf(s: String): Int {
    val charIndexMap = mutableMapOf<Char, Int>()
    var maxLength = 0
    var start = 0

    for (end in s.indices) {
        val currentChar = s[end]
        if (charIndexMap.containsKey(currentChar)) {
            start = maxOf(start, charIndexMap[currentChar]!! + 1)
        }
        charIndexMap[currentChar] = end
        maxLength = maxOf(maxLength, end - start + 1)
    }
    return maxLength
}

fun main() {
    print("Введите строку символов: ")
    val inputString = readLine() ?: ""
    val startTime = System.nanoTime()
    val result = lengthOf(inputString)
    val elapsedTime = System.nanoTime() - startTime
    println("Времени затрачено: %.4f мс".format(elapsedTime / 10.0.pow(6)))
    println("Длина самой длинной подстроки для '$inputString': $result")
}