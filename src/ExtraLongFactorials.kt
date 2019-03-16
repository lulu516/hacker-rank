/***
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
import java.math.BigInteger
import java.util.*

fun extraLongFactorials(n: Int): Unit {
    var result = BigInteger.ONE
    (1..n).forEach { result *= it.toBigInteger() }
    println(result)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    extraLongFactorials(n)
}

