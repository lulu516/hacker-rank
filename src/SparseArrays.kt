/***
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
import java.util.*
import kotlin.collections.*

// Complete the matchingStrings function below.
fun matchingStrings(strings: Array<String>, queries: Array<String>): Array<Int> {
    val countMap = mutableMapOf<String, Int>()

    strings.forEach { str -> countMap[str] = countMap.getOrDefault(str, 0) + 1 }

    return queries.map { query -> countMap.getOrDefault(query, 0) }.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val stringsCount = scan.nextLine().trim().toInt()

    val strings = Array<String>(stringsCount, { "" })
    for (i in 0 until stringsCount) {
        val stringsItem = scan.nextLine()
        strings[i] = stringsItem
    }

    val queriesCount = scan.nextLine().trim().toInt()

    val queries = Array<String>(queriesCount, { "" })
    for (i in 0 until queriesCount) {
        val queriesItem = scan.nextLine()
        queries[i] = queriesItem
    }

    val res = matchingStrings(strings, queries)

    println(res.joinToString("\n"))
}
