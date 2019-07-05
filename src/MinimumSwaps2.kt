/***
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
import java.util.*
import kotlin.collections.*

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var counter = 0
    val indexMap = mutableMapOf<Int, Int>()
    for (i in 0 until arr.size) {
        indexMap[arr[i]] = i
    }

    for (i in 0 until arr.size - 1) {
        if (arr[i] != i + 1) {
            val wrongIndex = indexMap[i + 1]!!
            val wrongValue = arr[i]
            arr[i] = i + 1
            arr[wrongIndex] = wrongValue
            indexMap[wrongValue] = wrongIndex

            counter++
        }
    }

    return counter
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
