fun main() {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ"
    println("Выберите действие: 1 - Зашифровать, 2 - Дешифровать")
    val action = readln().toInt()

    println("Введите ключевое слово:")
    val keyword = readln().uppercase() //преобразуем введенное слово в верхний регистр

    println("Введите текст:")
    val text = readln().uppercase() //преобразуем введенное слово в верхний регистр

    val result = StringBuilder() //объект для хранения результата
    //Вычисляем смещения для каждого символа ключевого слова при помощи списка смещений
    //Ключ: символ из ключевого слова
    //Значение: позиция символа в алфавите + 1 (смещение)
    val shifts = keyword.map { it - 'А' + 1 }

    //Проходим по каждому символу текста
    for (i in text.indices) { //indices возвращает диапазон от 0 до длины строки text минус один
        val char = text[i] //Получаем текущий символ
        if (char in alphabet) { // Проверяем, является ли символ частью алфавита
            val shift = shifts[i % shifts.size] // Получаем смещение для текущего символа на основе ключевого слова
            val index = alphabet.indexOf(char) // Находим индекс текущего символа в алфавите
            //Вычисляем новый индекс в зависимости от действия (шифрование или дешифрование)
            val newIndex = if (action == 1) (index + shift) % alphabet.length else (index - shift + alphabet.length) % alphabet.length
            //Добавляем новый символ в результат
            result.append(alphabet[newIndex]) //При помощи append добавляем указанный символ в конец объекта
        } else {
            result.append(char) //Если символ не в алфавите, добавляем его без изменений
        }
    }

    println("Результат: $result")
}