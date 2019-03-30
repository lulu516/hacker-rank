/**
 * https://www.hackerrank.com/challenges/encryption/problem
 */
import java.util.*
import kotlin.math.ceil

// Complete the encryption function below.
fun encryption(s: String): String {
    // calculate column and row: be care c * r >= l otherwise row + 1 -> r is not used
    val l = s.length
    val c = ceil(Math.sqrt(l.toDouble())).toInt()

    // construct 2 dimension array/list
    val strList = mutableListOf<String>()
    val chunked = s.chunked(c)

    // construct outcome: get char with same c from row
    for (i in 0 until c) {
        var str = ""
        chunked.forEach {
            if (i <= it.length - 1)  str += it[i]
        }

        strList.add(str)
    }

    return strList.joinToString(" ")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = encryption(s)

    println(result)
}
