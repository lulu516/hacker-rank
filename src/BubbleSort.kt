/***
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 */
import java.util.*

// Complete the countSwaps function below.
fun countSwaps(a: Array<Int>): Unit {
    var num = 0

    for (i in 0 until a.size - 1) {
        for(j in 0 until a.size - i - 1) {
            if (a[j] > a[j + 1]) {
                val temp = a[j + 1]
                a[j + 1] = a[j]
                a[j] = temp
                num++
            }
        }
    }

    println("Array is sorted in $num swaps.")
    println("First Element: ${a[0]}")
    println("Last Element: ${a.last()}")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val a = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    countSwaps(a)
}
