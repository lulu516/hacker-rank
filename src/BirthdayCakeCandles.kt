/***
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
import java.util.*

/*
* Complete the birthdayCakeCandles function below.
*/
fun birthdayCakeCandles(n: Int, ar: Array<Int>): Int {
    val arrayDesc = ar.sortedArrayDescending()
    return arrayDesc.takeWhile { it == arrayDesc.firstOrNull() }.size
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = birthdayCakeCandles(n, ar)

    println(result)
}
