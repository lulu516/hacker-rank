/***
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
import java.util.*
import kotlin.math.abs

// Complete the diagonalDifference function below.
fun diagonalDifference(arr: Array<Array<Int>>): Int {
    val num = arr.size
    var diagonal1 = 0
    var diagonal2 = 0
    for (i in 0 until num) {
        diagonal1 += arr[i][i]
        diagonal2 += arr[i][num - i - 1]
    }

    return abs(diagonal1 - diagonal2)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

    for (i in 0 until n) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}
