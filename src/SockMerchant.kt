/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
import java.util.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    var result = 0
    val countMap = ar.groupingBy { it }.eachCount()

    countMap.forEach { result += it.value / 2 }
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}

