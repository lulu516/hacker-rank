/***
 * https://www.hackerrank.com/challenges/time-conversion/problem?h_r=profile
 */
import java.util.*

/*
* Complete the timeConversion function below.
*/
fun timeConversion(s: String): String {
    /*
     * Write your code here.
     */
    val isAfternoon = s.takeLast(2) == "PM"
    val hour = s.substring(0, 2).let {
        when (it) {
            "12" -> if (isAfternoon) "12" else "00"
            else -> if (isAfternoon) (it.toInt() + 12).toString() else it
        }
    }
    val minute = s.substring(3, 5)
    val second = s.substring(6, 8)

    return "$hour:$minute:$second"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = timeConversion(s)

    println(result)
}