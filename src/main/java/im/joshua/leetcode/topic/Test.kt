package im.joshua.leetcode.topic


/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2020/8/5 16:10
 */

fun main(args: Array<String>) {
    val code = "3052334"
    println("${code.toByteArray().joinToString()}")
}

class Test(val s: String, val p: String) : LeetCodeTopic<Boolean>() {

    override fun formatParams() {
        params.addProperty("s", s)
        params.addProperty("p", p)
    }

    override fun solution(): Boolean {

        return false
    }
}