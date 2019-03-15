/***
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */
import java.util.*

// Complete the climbingLeaderboard function below.
fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {
    val sortedDescending = scores.distinct().sortedDescending()
    return alice.map {
        val order = sortedDescending.binarySearch(it, Collections.reverseOrder<Int>())
        if (order < 0) -order else order + 1
    }.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val scoresCount = scan.nextLine().trim().toInt()

    val scores = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val aliceCount = scan.nextLine().trim().toInt()

    val alice = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = climbingLeaderboard(scores, alice)

    println(result.joinToString("\n"))
}

