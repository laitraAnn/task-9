fun main() {
    print("Введите элементы массива через запятую: ")
    val inputArray = readLine()!!.split(",").map { it.trim().toInt() }
    print("target: ")
    val targetValue = readLine()!!.toInt()

    val startTime = System.nanoTime()
    var foundIndices: Pair<Int, Int>? = null

    for (i in inputArray.indices) {
        for (j in inputArray.indices) {
            if (i != j && inputArray[i] + inputArray[j] == targetValue) {
                foundIndices = Pair(i, j)
                break
            }
        }
        if (foundIndices != null) break
    }

    val elapsedTime = System.nanoTime() - startTime
    println("Время выполнения: ${elapsedTime / 1_000_000.0} мс")
    print("Результат: ")

    if (foundIndices == null) {
        println("Совпадений не найдено")
    } else {
        println(" ${foundIndices.first}, ${foundIndices.second}")
    }
}