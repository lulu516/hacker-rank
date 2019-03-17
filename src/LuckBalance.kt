/***
 * https://www.hackerrank.com/challenges/luck-balance/problem
 */
import java.util.*

// Complete the luckBalance function below.
fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    val total = contests.sumBy { it[0] }
    val important = contests.filter { it[1] == 1 }
    val succeedSize = if (important.size >= k) important.size - k else 0
    val deduct = important.sortedBy { it[0] }.take(succeedSize).sumBy { it[0] }
    return total - 2 * deduct
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val contests = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

    for (i in 0 until n) {
        contests[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = luckBalance(k, contests)

    println(result)
}
