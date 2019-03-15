/***
 * https://www.hackerrank.com/challenges/two-strings/problem
 */
import java.util.*

// Complete the twoStrings function below.
fun twoStrings(s1: String, s2: String): String {
    val s2L = s2.toCharArray().groupBy {it}
    for (i in s1.toCharArray()) {
        if (s2L.containsKey(i)) {
            return "YES"
        }
    }

    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s1 = scan.nextLine()

        val s2 = scan.nextLine()

        val result = twoStrings(s1, s2)

        println(result)
    }
}
