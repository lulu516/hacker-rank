/***
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
import java.util.*


// Complete the checkMagazine function below.
fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    var a = magazine.toMutableList()
    note.forEach {
        val index = a.indexOf(it)
        if (index != -1) {
            a.removeAt(index)
        } else {
            println("No")
            return
        }
    }

    println("Yes")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val mn = scan.nextLine().split(" ")

    val m = mn[0].trim().toInt()

    val n = mn[1].trim().toInt()

    val magazine = scan.nextLine().split(" ").toTypedArray()

    val note = scan.nextLine().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}

