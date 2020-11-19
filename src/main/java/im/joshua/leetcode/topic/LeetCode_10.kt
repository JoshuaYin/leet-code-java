package im.joshua.leetcode.topic

import java.lang.StringBuilder
import kotlin.math.max
import kotlin.math.min

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

class LeetCode_10(val s: String, val p: String) : LeetCodeTopic<Boolean>() {

    override fun formatParams() {
        params.addProperty("s", s)
        params.addProperty("p", p)
    }

    override fun solution(): Boolean {
        return false
    }
}