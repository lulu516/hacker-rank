/***
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */
import java.text.DecimalFormat
import java.util.*

/*
* Complete the plusMinus function below.
*/
fun plusMinus(arr: Array<Int>): Unit {
    val decimalFormat = DecimalFormat("#0.00000")
    val size = arr.size.toDouble()
    println(decimalFormat.format(arr.filter { it > 0 }.size / size))
    println(decimalFormat.format(arr.filter { it < 0 }.size / size))
    println(decimalFormat.format(arr.filter { it == 0 }.size / size))
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    plusMinus(arr)
}

