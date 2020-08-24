package im.joshua.leetcode.topic

import java.lang.StringBuilder
import java.util.*
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2020/8/5 16:10
 */

//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
//
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
// string convert(string s, int numRows);
//
// 示例 1:
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
//
//
// 示例 2:
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
// Related Topics 字符串
// 👍 800 👎 0
fun main(args: Array<String>) {
    val topic = LeetCode_6("AB", 1)
    println(topic.solve())
}

class LeetCode_6(val s: String, val numRows: Int) : LeetCodeTopic() {

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