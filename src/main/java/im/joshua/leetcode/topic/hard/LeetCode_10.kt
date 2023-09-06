package im.joshua.leetcode.topic.hard

import im.joshua.leetcode.topic.LeetCodeTopic


/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2020/8/5 16:10
 */

fun main(args: Array<String>) {
    val topic = LeetCode_10("-91283472332", "")
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