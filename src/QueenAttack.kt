/***
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
import java.util.*

// Complete the queensAttack function below.
fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {
    var obstaclesMap = mutableMapOf<Int, MutableList<Int>>()
    obstacles.forEach {
        if (obstaclesMap.containsKey(it[0])) {
            val index = getIndex(obstaclesMap[it[0]]!!, it[1])

            if (index == obstaclesMap[it[0]]!!.size) {
                obstaclesMap[it[0]]!!.add(it[1])
            } else {
                obstaclesMap[it[0]]!!.add(index, it[1])
            }
        } else {
            obstaclesMap.put(it[0], mutableListOf(it[1]))
        }
    }

    var result = 0

    // straight down
    if (r_q > 1) {
        for (i in (r_q - 1) downTo 1) {
            if (isNotObstacle(obstaclesMap, i, c_q)) result++
            else break
        }
    }

    // straight up
    if (r_q < n) {
        for (i in (r_q + 1)..n) {
            if (isNotObstacle(obstaclesMap, i, c_q)) result++
            else break
        }
    }

    // straight left
    if (c_q > 1) {
        for (i in (c_q - 1) downTo 1) {
            if (isNotObstacle(obstaclesMap, r_q, i)) result++
            else break
        }
    }

    // straight right
    if (c_q < n) {
        for (i in (c_q + 1)..n) {
            if (isNotObstacle(obstaclesMap, r_q, i)) result++
            else break
        }
    }

    // left down
    if (r_q > 1 && c_q > 1) {
        var r = r_q - 1
        var c = c_q - 1
        while (r >= 1 && c >= 1) {
            if (isNotObstacle(obstaclesMap, r, c)) {
                result++
                r--
                c--
            } else break
        }
    }

    // right up
    if (r_q < n && c_q < n) {
        var r = r_q + 1
        var c = c_q + 1
        while (r <= n && c <= n) {
            if (isNotObstacle(obstaclesMap, r, c)) {
                result++
                r++
                c++
            } else break
        }
    }

    //left up
    if (r_q < n && c_q > 1) {
        var r = r_q + 1
        var c = c_q - 1
        while (r <= n && c >= 1) {
            if (isNotObstacle(obstaclesMap, r, c)) {
                result++
                r++
                c--
            } else break
        }
    }

    //right down
    if (r_q > 1 && c_q < n) {
        var r = r_q - 1
        var c = c_q + 1
        while (r >= 1 && c <= n) {
            if (isNotObstacle(obstaclesMap, r, c)) {
                result++
                r--
                c++
            } else break
        }
    }

    return result
}

fun isNotObstacle(obstaclesMap: MutableMap<Int, MutableList<Int>>, row: Int, column: Int) =
        !obstaclesMap.containsKey(row) || obstaclesMap[row]!!.binarySearch(column) < 0

fun getIndex(list: List<Int>, element: Int) : Int{
    val index = list.binarySearch(element)

    if (index < 0) {
        return (index + 1) * (-1)
    }
    return index
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val r_qC_q = scan.nextLine().split(" ")

    val r_q = r_qC_q[0].trim().toInt()

    val c_q = r_qC_q[1].trim().toInt()

    val obstacles = Array<Array<Int>>(k, { Array<Int>(2, { 0 }) })

    for (i in 0 until k) {
        obstacles[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = queensAttack(n, k, r_q, c_q, obstacles)

    println(result)
}
