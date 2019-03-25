/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */
import java.util.*

// Complete the biggerIsGreater function below.
fun biggerIsGreater(w: String): String {
    val sortedChars = w.toCharArray().distinct().sorted().toList()
    val length = w.length

    for(i in (length - 2) downTo 0) {
        val rightList = w.substring(i + 1, length)
        val currentChar = w[i]
        val index = findNextBiggerCharIndex(currentChar, sortedChars, rightList)

        if (index != null) {
            val nextBiggerChar = rightList[index]
            val list = w.substring(i, length).toMutableList()
            list.removeAt(index + 1)
            list.sort()
            return w.substring(0, i) + nextBiggerChar + String(list.toCharArray())
        }
    }

    return "no answer"
}

fun findNextBiggerCharIndex(current: Char, sortedChar: List<Char>, lookUpString: String): Int? {
    val currentIndex = sortedChar.indexOf(current)

    sortedChar.subList(currentIndex + 1, sortedChar.size).forEach {
        val index = lookUpString.indexOf(it)
        if (index >= 0) return index
    }

    return null
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val T = scan.nextLine().trim().toInt()

    for (TItr in 1..T) {
        val w = scan.nextLine()

        val result = biggerIsGreater(w)

        println(result)
    }
}