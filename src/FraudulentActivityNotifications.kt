/***
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 */

import java.util.*

// Complete the activityNotifications function below.
fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    return if (expenditure.size == d)
        0
    else {
        var result = 0
        val list = expenditure.take(d).sorted().toMutableList()
        for (i in d until expenditure.size) {
            val limit = getLimit(list, d)
            if (expenditure[i] >= limit) result++

            list.removeAt(getIndex(list, expenditure[i - d]))
            list.add(getIndex(list, expenditure[i]), expenditure[i])
        }
        result
    }
}

fun getIndex(sortedList: List<Int>, element: Int): Int {
    val index = sortedList.binarySearch(element)
    return if (index < 0)
        (index + 1) * -1
    else index
}

fun getLimit(sortedList: List<Int>, size: Int): Long {
    return if (size % 2 == 0) {
        sortedList[size / 2 - 1].toLong() + sortedList[size / 2].toLong()
    } else {
        (sortedList[size / 2] * 2).toLong()
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val expenditure = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = activityNotifications(expenditure, d)

    println(result)
}
