/***
 * https://www.hackerrank.com/challenges/repeated-string/problem?h_r=profile
 */
import java.util.*

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    val freqUnit = Collections.frequency(s.toCharArray().toList(), 'a')

    val size = s.toCharArray().size
    var repeatNum = n.div(size) * freqUnit
    if (n.rem(size) > 0) {
        for (i in 0 until n.rem(size)) {
            if (s[i.toInt()] == 'a') repeatNum++
        }
    }

    return repeatNum

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}

