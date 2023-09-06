package im.joshua.leetcode.topic.easy

import im.joshua.leetcode.topic.LeetCodeTopic

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2023/1/10 15:26
 */

fun main(args: Array<String>) {
    val topic = LeetCode_13("XLIX")
    println(topic.solve())
}

class LeetCode_13(val s: String) : LeetCodeTopic<Int>() {

    override fun formatParams() {
        params.addProperty("s", s)
    }

    override fun solution(): Int {
        var num = 0
        var preNum = 0
        for (c in s) {
            val cur = getInt(c)

            if (cur > preNum) {
                num -= preNum
            } else {
                num += preNum
            }

            println("[pre]:$preNum [cur]:$cur [num]:$num")
            preNum = cur
        }
        num += preNum

        return num
    }

    fun getInt(c: Char): Int {
        return when (c) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }
}