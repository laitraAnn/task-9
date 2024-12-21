fun isPalindrome(x: Int): Boolean {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false
    }

    var reversedNumber = 0
    var originalNumber = x

    while (originalNumber > 0) {
        val digit = originalNumber % 10
        reversedNumber = reversedNumber * 10 + digit
        originalNumber /= 10
    }
    return x == reversedNumber
}

fun main() {
    println("Введите целое число:")
    val input = readLine()
    val startTime = System.nanoTime()
    if (input != null) {
        val x = input.toIntOrNull()
        if (x != null) {
            val result = isPalindrome(x)
            val elapsedTime = System.nanoTime() - startTime
            println("Времени затрачено: ${elapsedTime / 1000000.0} мс")
            println("Результат: $result")
        } else {
            println("Ошибка.")
        }
    } else {
        println("Ошибка")
    }
}