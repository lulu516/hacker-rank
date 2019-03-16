/***
 * https://www.hackerrank.com/challenges/staircase/problem
 */
import java.util.*

/*
* Complete the staircase function below.
*/
fun staircase(n: Int): Unit {
    for (i in 1..n) {
        println(" ".repeat(n - i) + "#".repeat(i))
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    staircase(n)
}
