package im.joshua.leetcode.topic.medium

import im.joshua.leetcode.topic.LeetCodeTopic

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2020/8/5 16:10
 */


fun main(args: Array<String>) {
    val topic = LeetCode_8("-91283472332")
    println(topic.solve())
}

class LeetCode_8(val s: String) : LeetCodeTopic<Int>() {

    override fun formatParams() {
        params.addProperty("s", s)
    }

    override fun solution(): Int {
        if (s.isNullOrBlank()) return 0

        var positive = 1
        var index = 0
        var value = 0L
        val len = s.length
        val charArr = s.toCharArray()
        while (index < len && charArr[index] == ' ')
            index++

        if (index > len - 1) return 0

        positive = if (charArr[index] == '-') -1 else 1
        if (charArr[index] == '+' || charArr[index] == '-') index++

        for (i in index until len) {
            val c = charArr[i]
            if (c in '0'..'9') {
                value = value * 10 + (charArr[i] - '0')
                println("value = $value")
                if (value * positive > Int.MAX_VALUE) return Int.MAX_VALUE
                if (value * positive < Int.MIN_VALUE) return Int.MIN_VALUE
            } else {
                break
            }
        }

        return (value * positive).toInt()
    }
}