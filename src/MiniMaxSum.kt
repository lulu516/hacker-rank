/***
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
import java.util.*

/*
* Complete the miniMaxSum function below.
*/
fun miniMaxSum(arr: Array<Int>): Unit {
    arr.sortedArray()
            .map { it.toLong() }
            .also { print(it.take(4).sum().toString() + " ") }
            .also { print(it.takeLast(4).sum()) }

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    miniMaxSum(arr)
}