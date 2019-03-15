/***
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_r=profile
 */
import java.util.*

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: List<Int>): Int {
    if (c.size <= 3) return 1

    var step = 1

    step += if (c[2] == 0)
        jumpingOnClouds(c.subList(2, c.size))
    else
        jumpingOnClouds(c.subList(1, c.size))

    return step
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toList()

    val result = jumpingOnClouds(c)

    println(result)
}

