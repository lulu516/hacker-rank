/***
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */

import java.util.*

// Complete the minimumBribes function below.
fun minimumBribes(q: Array<Int>): Unit {
    try {
        val count = countBribes(q, mutableListOf())
        println(count)
    } catch (e: Exception) {
        println("Too chaotic")
    }
}

@Throws(Exception::class)
internal fun countBribes(q: Array<Int>, movedNumbers: MutableList<Int>): Int {
    val size = q.size
    var count = 0

    for (i in 0 until size) {
        val movedTimes = Collections.binarySearch(movedNumbers, q[i], Comparator.reverseOrder()) * -1 - 1
        val originalPos = q[i] - 1 + movedTimes
        if (originalPos > i) {
            if (originalPos - i > 2) {
                throw Exception()
            } else {
                count += originalPos - i
                movedNumbers.add(movedTimes, q[i])
            }
        }
    }

    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        minimumBribes(q)
    }
}