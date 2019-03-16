/***
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
import kotlin.math.min

// Complete the compareTriplets function below.
fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    val size = min(a.size, b.size)
    var resultA = 0
    var resultB = 0
    for (i in 0 until size) {
        if (a[i] > b[i]) resultA++
        if (a[i] < b[i]) resultB++
    }

    return arrayOf(resultA, resultB)
}

fun main(args: Array<String>) {
    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val b = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = compareTriplets(a, b)

    println(result.joinToString(" "))
}
