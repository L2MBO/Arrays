fun main() {
    print("Введите количество строк: ")
    val rows = readln().toInt()
    print("Введите количество столбцов: ")
    val cols = readln().toInt()

    val array = Array(rows) { IntArray(cols) }

    val prod = rows * cols

    println("Введите $prod трехзначных чисел(а): ")
    for (i in 0..< rows) {
        for (j in 0..< cols) {
            array[i][j] = readln().toInt()
            if (array[i][j] < 100 || array[i][j] > 999) {
                print("Числа должны быть трехзначными")
                return
            }
        }
    }

    //уникальное множество отсеевающее дубликаты
    val uniqueDigits = mutableSetOf<Char>()

    for (i in 0..< rows) {
        for (j in 0..< cols) {
            val number = array[i][j].toString()
            for (digit in number) {
                uniqueDigits.add(digit)
            }
        }
    }

    val result = uniqueDigits.size

    println("Двумерный массив: ")
    for (i in 0..< rows) {
        for (j in 0..< cols) {
            print("${array[i][j]} ")
        }
        println()
    }

    print("В массиве использовано $result различных цифр.")
}