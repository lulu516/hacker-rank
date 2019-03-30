/***
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 */
import java.util.*

// Complete the organizingContainers function below.
fun organizingContainers(container: Array<Array<Int>>): String {
    val containerSize = container.map { it.sum() }
    val ballCount = mutableMapOf<Int, Int>()
    for (c in container) {
        for (i in c.indices) {
            ballCount[i] = ballCount.getOrDefault(i, 0) + c[i]
        }
    }

    return if (ballCount.values.sorted() == containerSize.sorted()) {
        "Possible"
    } else {
        "Impossible"
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val n = scan.nextLine().trim().toInt()

        val container = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

        for (i in 0 until n) {
            container[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        }

        val result = organizingContainers(container)

        println(result)
    }
}
