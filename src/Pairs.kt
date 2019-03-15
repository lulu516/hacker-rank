/***
 * https://www.hackerrank.com/challenges/pairs/problem
 */
import java.util.*

// Complete the pairs function below.
fun pairs(k: Int, arr: Array<Int>): Int {
    val hashSet = arr.toHashSet()

    var result = 0

    hashSet.forEach { if (hashSet.contains(it + k)) result++ }

    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = pairs(k, arr)

    println(result)
}
