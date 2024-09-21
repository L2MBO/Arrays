fun main() {
    val words = listOf("eat", "tea", "tan", "ate", "nat", "bat")

    // Группируем слова по отсортированным символам
    // С помощью метода groupBy создаем мапу где ключом на сонове заданного условия будет строка из отсортированных символов
    // А значением будет список слов анаграмм
    val groupedAnagrams = words.groupBy { it.toCharArray().sorted().joinToString("") }
    println(groupedAnagrams)
    // Выводим группы
    for (group in groupedAnagrams.values) { // С помощью values получаем только группы (все значения) без ключей
        println(group.joinToString(", "))
    }
}
