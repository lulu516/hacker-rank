/***
 * https://www.hackerrank.com/challenges/mark-and-toys/problem
 */

import java.util.*

// Complete the maximumToys function below.
fun maximumToys(prices: Array<Int>, k: Int): Int {
    val list = prices.sorted()

    var result = 0
    var price = 0

    list.forEach {
        price += it
        if (price >= k) return result
        else result++
    }

    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val prices = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = maximumToys(prices, k)

    println(result)
}