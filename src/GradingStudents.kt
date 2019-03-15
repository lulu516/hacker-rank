/***
 * https://www.hackerrank.com/challenges/grading/problem?h_r=profile
 */
import java.util.*

/*
* Complete the gradingStudents function below.
*/
fun gradingStudents(grades: Array<Int>): Array<Int> {
    return grades.map {
        val nextMultiple = Math.ceil(it / 5.0).toInt() * 5
        if (it >= 38 && nextMultiple - it < 3) nextMultiple else it
    }.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val grades = Array<Int>(n, { 0 })
    for (gradesItr in 0 until n) {
        val gradesItem = scan.nextLine().trim().toInt()
        grades[gradesItr] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}
