/***
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 */
import java.util.*

// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var level = 0
    var valley = 0
    for (c in s.toCharArray()) {
        when (c) {
            'U' -> level++
            'D' -> level--
        }
        if (level == -1 && c == 'D') valley++
    }

    return valley
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}
