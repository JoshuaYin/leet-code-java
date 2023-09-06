package im.joshua.leetcode.topic.medium

import im.joshua.leetcode.topic.LeetCodeTopic
import kotlin.math.max
import kotlin.math.min

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2020/8/5 16:10
 */
fun main(args: Array<String>) {
    val topic = LeetCode_6("AB", 1)
    println(topic.solve())
}

class LeetCode_6(val s: String, val numRows: Int) : LeetCodeTopic<String>() {

    override fun formatParams() {
        params.addProperty("s", s)
        params.addProperty("numRows", numRows)
    }

    override fun solution(): String {
        if (s.isNullOrEmpty() || numRows < 1)
            return s
        if (s.length <= numRows)
            return s

        val len = s.length
        val charArr = s.toCharArray()
        val arr = Array(numRows) { mutableListOf<Int>() }
        var status = 1
        var row = 0

        main@
        for (i in 0 until len) {
            arr[row].add(charArr[i].toInt())
            when (row) {
                0 -> {
                    row = min(row + 1, numRows - 1)
                    status = 1
                }
                numRows - 1 -> {
                    row = max(row - 1, 0)
                    status = -1
                }
                else -> {
                    row += (1 * status)
                }
            }
        }

        val sb = StringBuilder("\n")
        for (i in 0 until numRows) {
            for (num in arr[i]) {
                sb.append("${num.toChar()} ")
            }
            sb.append("\n")
        }

        return sb.toString()
    }
}